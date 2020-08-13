package com.oriongroup.restaurant.repository.JpaImpl;

import com.oriongroup.restaurant.model.Vote;
import com.oriongroup.restaurant.repository.JPA.VoteRepo;
import com.oriongroup.restaurant.repository.extendDataJpa.RestaurantJPA;
import com.oriongroup.restaurant.repository.extendDataJpa.UserJPA;
import com.oriongroup.restaurant.repository.extendDataJpa.VoteJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class VoteJpaImpl implements VoteRepo {
    private final VoteJPA voteJPA;
    private final UserJPA userJPA;
    private final RestaurantJPA restaurantJPA;

    public VoteJpaImpl(VoteJPA voteJPA, UserJPA userJPA, RestaurantJPA restaurantJPA) {
        this.voteJPA = voteJPA;
        this.userJPA = userJPA;
        this.restaurantJPA = restaurantJPA;
    }

    @Override
    public List<Vote> getAll(int restaurantId) {
        return voteJPA.getAll(restaurantId);
    }

    @Override
    @Transactional
    public Vote save(Vote vote, int restaurantId, int userId) {
        if (!vote.isNew()&&get(vote.getId(),restaurantId,userId)==null ){return null;}
        vote.setRestaurant(restaurantJPA.getOne(restaurantId));
        vote.setUser(userJPA.getOne(userId));

        return voteJPA.save(vote);
    }

    @Override
    public Vote get(int id, int restaurantId, int userId) {
        return voteJPA.findById(id)
                .filter(vote -> vote.getRestaurant().getId()==restaurantId&&vote.getUser().getId()==userId)
                .orElse(null);
    }

    @Override
    public boolean delete(int id,int restaurantId,int userId) {
        return voteJPA.delete(id,restaurantId,userId)!=0;
    }
}