package com.oriongroup.restaurant.repository.JPA;

import com.oriongroup.restaurant.model.User;

import java.util.List;

public interface UserRepo {
    List<User> getAll();

    User save(User user);

    User get(Integer id);

    boolean delete(Integer id);


}
