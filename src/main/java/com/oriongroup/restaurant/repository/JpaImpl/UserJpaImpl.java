package com.oriongroup.restaurant.repository.JpaImpl;


import com.oriongroup.restaurant.model.User;
import com.oriongroup.restaurant.repository.JPA.UserRepo;
import com.oriongroup.restaurant.repository.extendDataJpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserJpaImpl implements UserRepo {
    private final UserJPA userJPA;
    @Autowired
    public UserJpaImpl(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public List<User> getAll() {
        return userJPA.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }

    @Override
    public User save(User user) {
        return userJPA.save(user);
    }

    @Override
    public User get(Integer id) {
        return userJPA.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        return userJPA.delete(id)!=0;
    }

    @Override
    public User getByEmail(String email) {
        return userJPA.getByEmail(email);
    }
}
