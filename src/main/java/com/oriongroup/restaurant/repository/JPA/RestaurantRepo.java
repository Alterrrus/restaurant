package com.oriongroup.restaurant.repository.JPA;

import com.oriongroup.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantRepo {

    List<Restaurant> getAll();

    Restaurant save(Restaurant restaurant);

    Restaurant get(Integer id);

    boolean delete(Integer id);

    default List<Restaurant> findAllWithDishListByIdNotNull(){throw new UnsupportedOperationException();}
}
