package com.oriongroup.restaurant;

import com.oriongroup.restaurant.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RestTestData {
    public static TestMatcher<Restaurant>REST_TEST_MATCHER=TestMatcher.usingFieldsWithIgnoringComparator(Restaurant.class,"voteList","dishList");
    public static TestMatcher<Dish>DISH_TEST_MATHER= TestMatcher.usingEqualsComparator(Dish.class);
    public static TestMatcher<Dish>DISH_TEST_MATHER1= TestMatcher.usingFieldsWithIgnoringComparator(Dish.class,"restaurant");
    public static TestMatcher<User>USER_TEST_MATCHER=TestMatcher.usingFieldsWithIgnoringComparator(User.class,"voteList","registered");


    public static final Vote VOTE_A1=new Vote(10004,10000,10002, LocalDateTime.of(2020,1,30,10,0));
    public static final Vote VOTE_A2=new Vote(10005,10000,10002, LocalDateTime.of(2020,1,29,10,0));
    public static final Vote VOTE_U1=new Vote(10006,10001,10003, LocalDateTime.of(2020,1,30,10,0));
    public static final Vote VOTE_U2=new Vote(10007,10001,10003, LocalDateTime.of(2020,1,29,10,0));

    public static final List<Vote>VOTE_LIST_L=List.of(VOTE_A1,VOTE_A2);
    public static final List<Vote>VOTE_LIST_C=List.of(VOTE_U1,VOTE_U2);

    public static final User ADMIN=new User(10000,"admin","admin@gmail.com","admin", Role.ADMIN);
    public static final User USER=new User(10001,"user","user@gmail.com","user",Role.USER);
    public static final User NEW_USER=new User("new","new@gmail.com","new",true,new Date(),Collections.singleton(Role.USER));
    public static final List<User>USER_LIST= List.of(ADMIN,USER);

    public static final Dish DISH_L1=new Dish(10008,"супчик",new BigDecimal(500));
    public static final Dish DISH_L2=new Dish(10009,"мяско",new BigDecimal(500));
    public static final Dish DISH_L3=new Dish(10010,"кролик",new BigDecimal(500));
    public static final Dish DISH_L4=new Dish(10011,"рагу",new BigDecimal(500));
    public static final Dish DISH_C1=new Dish(10012,"еда",new BigDecimal(500));
    public static final Dish DISH_C2=new Dish(10013,"пища",new BigDecimal(500));
    public static final Dish DISH_C3=new Dish(10014,"ролы",new BigDecimal(500));
    public static final Dish DISH_C4=new Dish(10015,"суши",new BigDecimal(500));

    public static final Dish DISH_NEW=new Dish(null,"Новая еда",new BigDecimal(200));
    public static final List<Dish>DISH_LIST_L=List.of(DISH_L3,DISH_L2,DISH_L4,DISH_L1);
    public static final List<Dish>DISH_LIST_C=List.of(DISH_C1,DISH_C2,DISH_C3,DISH_C4);


    public static final Restaurant REST_L=new Restaurant(10002,VOTE_LIST_L,DISH_LIST_L,"Ласточка");
    public static final Restaurant REST_C=new Restaurant(10003,VOTE_LIST_C,DISH_LIST_C,"СССР");
    public static final List<Restaurant>RESTAURANT_LIST=List.of(REST_L,REST_C);

}
