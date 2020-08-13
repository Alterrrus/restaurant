package com.oriongroup.restaurant.repository.JPA;

import com.oriongroup.restaurant.model.Vote;

import java.util.List;

public interface VoteRepo {
    List<Vote> getAll(int restaurantId);

    Vote save(Vote vote,int restaurantId,int userId);

    Vote get(int id,int restaurantId,int userId);

    boolean delete(int id,int restaurantId,int userId);
}
