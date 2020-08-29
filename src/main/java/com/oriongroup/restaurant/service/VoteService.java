package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.Vote;
import com.oriongroup.restaurant.repository.JPA.VoteRepo;
import com.oriongroup.restaurant.web.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;
@Service
public class VoteService extends AbstractService {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final VoteRepo voteRepo;

    public VoteService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public List<Vote> getByTimeExist(int userId) {
        LocalDate dateTime = LocalDate.now();
        return voteRepo.getByTimeExist(userId, dateTime.atStartOfDay(), dateTime.atTime(23, 59, 59));
    }

    public boolean delete(int id, int restaurantId, int userId) {
        return voteRepo.delete(id, restaurantId, userId);
    }

    public Vote get(int id, int restaurantId, int userId) {
        return checkNotFoundWithId(voteRepo.get(id, restaurantId, userId),id);

    }

    public Vote save(int restaurantId) {
        int userId= SecurityUtil.authUserId();
        Vote base=voteRepo.getByTimeToDay(userId);

        if(base==null){return voteRepo.save(new Vote(userId,restaurantId),userId,restaurantId);}
        else
            if(base.getTimeExist().isAfter(LocalDate.now().atStartOfDay())
                    &&base.getTimeExist().isBefore(LocalDate.now().atTime(11,00,00))){
               voteRepo.update(restaurantId,base.id(),userId);
               return voteRepo.getByTimeToDay(userId);
            }
            else
                //checkNotFound(null,"сменить ваше нешение можно с 00 до 11");
                return base;
    }

    public List<Vote> getAll(int restaurantId) {
        return voteRepo.getAll(restaurantId);
    }

}
