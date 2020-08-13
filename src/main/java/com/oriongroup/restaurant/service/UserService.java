package com.oriongroup.restaurant.service;


import com.oriongroup.restaurant.model.User;
import com.oriongroup.restaurant.repository.JPA.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;
@Service
public class UserService {

    protected final Logger log= LoggerFactory.getLogger(getClass());
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public List<User> getAll(){
        log.info("getAll");
        List<User> u=userRepo.getAll();
        u.forEach(a->log.info("id:"+a.id()+" role:"+a.getRoles().toString()));
        return u;
    }

    public User get(Integer id){
        log.info("GET");
        return checkNotFoundWithId(userRepo.get(id),id);
    }

    public User create(User user){
        log.info("create");
        Assert.notNull(user,"user must not be null");
        return userRepo.save(user);
    }

    public void update(User user){
        log.info("update");
        Assert.notNull(user,"restaurant must not be null");
        checkNotFoundWithId(userRepo.save(user),user.id());
        log.info(user.getClass().getSimpleName()+":name:"+user.getName());
    }

    public void delete( int id){
        log.info("delete");
        checkNotFoundWithId(userRepo.delete(id),id);
    }
}
