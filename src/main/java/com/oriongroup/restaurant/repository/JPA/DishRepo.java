package com.oriongroup.restaurant.repository.JPA;

import com.oriongroup.restaurant.model.Dish;

import java.util.List;

public interface DishRepo {
    List<Dish> getAll(Integer restaurantId);

    Dish save(Dish dish,Integer restaurantId);

    Dish get(int id,int restaurantId);

    boolean delete(Integer id,Integer restaurantId);
}
