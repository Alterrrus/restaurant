package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.User;
import com.oriongroup.restaurant.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.oriongroup.restaurant.RestTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserServiceTest extends AbstractServiceTest{
    @Autowired
    protected UserService userService;


    @Test
    public void getAll(){
        List<User> users=userService.getAll();
        USER_TEST_MATCHER.assertMatch(users,USER_LIST);
    }


    @Test
    public void get(){
        User userA=userService.get(10000);
        User userU=userService.get(10001);
        USER_TEST_MATCHER.assertMatch(userA,ADMIN);
        USER_TEST_MATCHER.assertMatch(userU,USER);
    }
    @Test
    public void create() throws Exception {
        User user=userService.create(NEW_USER);
        int newId=user.id();
        User user1=NEW_USER;
        user1.setId(newId);
        USER_TEST_MATCHER.assertMatch(user,user1);
        USER_TEST_MATCHER.assertMatch(userService.get(newId),user1);
    }
    @Test
    public void delete()throws Exception{
        userService.delete(10000);
        assertThrows(NotFoundException.class, () -> userService.get(10000));
    }

    @Test
    void update() throws Exception {
        User updated = new User(ADMIN);
        updated.setName("updated");
        userService.update(updated);
        USER_TEST_MATCHER.assertMatch(userService.get(10000), updated);
    }

}