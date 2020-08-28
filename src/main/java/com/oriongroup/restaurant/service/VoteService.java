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
        List<Vote> voteForDay=getByTimeExist(userId);
        log.info("voteForDay:"+voteForDay.toString());
        LocalDate dateTime = LocalDate.now();
        Vote newVote=new Vote(userId,restaurantId);
        log.info("newVote:"+newVote.toString());
        if (voteForDay.size()==0){
            Vote v=voteRepo.save(newVote,restaurantId,userId);
            log.info("если не голосовал:"+v.toString()+" "+v.getTimeExist().toString());
            return v;}else

        if (voteForDay.size()==1){
            Vote vote=voteForDay.get(0);
            log.info("если голосовал:"+vote.toString()+" "+ vote.getTimeExist().toString());
            Vote v1;
        if (vote.getTimeExist().isAfter(dateTime.atStartOfDay())
                &&vote.getTimeExist().isBefore(dateTime.atTime(11,0,0,0))){
            v1=voteRepo.save(vote,restaurantId,userId);
            log.info("если голосуешь до 11:"+v1.toString()+" "+v1.getTimeExist().toString());
            return v1;}}
        log.info("если голосуешь после 11:"+voteForDay.get(0).toString()+" "+voteForDay.get(0).getTimeExist().toString());
        return voteForDay.get(0);
    }

    public List<Vote> getAll(int restaurantId) {
        return voteRepo.getAll(restaurantId);
    }

}
