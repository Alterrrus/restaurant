package com.oriongroup.restaurant.service;


import com.oriongroup.restaurant.model.Restaurant;
import com.oriongroup.restaurant.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.oriongroup.restaurant.RestTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RestServiceTest extends AbstractServiceTest{

    @Autowired
    private RestService service;
    @Test
    public void getAll(){
        List<Restaurant> restaurants=service.getAll();
        REST_TEST_MATCHER.assertMatch(restaurants,RESTAURANT_LIST);
    }
    @Test
    public void findAllWithDishList(){
        List<Restaurant> restaurants=service.findAllWithDishList();
        REST_TEST_MATCHER.assertMatch(restaurants,RESTAURANT_LIST);
        DISH_TEST_MATHER1.assertMatch(restaurants.get(0).getDishList(),DISH_L1,DISH_L2,DISH_L3,DISH_L4);
    }

    @Test
    public void get(){
        Restaurant restaurantL=service.get(10002);
        Restaurant restaurantC=service.get(10003);
        REST_TEST_MATCHER.assertMatch(restaurantL,REST_L);
        REST_TEST_MATCHER.assertMatch(restaurantC,REST_C);
    }
    @Test
    public void create() throws Exception {
        Restaurant restaurant=service.create(new Restaurant("У Ашота"));
        int newId=restaurant.id();
        Restaurant restaurant1=new Restaurant("У Ашота");
        restaurant1.setId(newId);
        REST_TEST_MATCHER.assertMatch(restaurant,restaurant1);
        REST_TEST_MATCHER.assertMatch(service.get(newId),restaurant1);
        }
        @Test
    public void delete()throws Exception{
        service.delete(10002);
            assertThrows(NotFoundException.class, () -> service.get(10002));
        }

    @Test
    void update() throws Exception {
        Restaurant updated = new Restaurant(REST_L);
        updated.setName("updated");

        service.update(updated,updated.id());
        REST_TEST_MATCHER.assertMatch(service.get(10002), updated);
    }



}