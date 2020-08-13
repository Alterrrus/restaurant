package com.oriongroup.restaurant.service;


import com.oriongroup.restaurant.model.Dish;
import com.oriongroup.restaurant.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static com.oriongroup.restaurant.RestTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DishServiceTest extends AbstractServiceTest{
        @Autowired
        private DishService service;

    @Test
    void delete() throws Exception {
        service.delete(10008, 10002);
        assertThrows(NotFoundException.class, () -> service.get(10008, 10002));
    }
    @Test
    void deleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(1000, 10002));
    }
    @Test
    void deleteNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(10012, 10002));
    }
    @Test
    void create() throws Exception {
        Dish created = service.create(new Dish(null,"Новая еда",new BigDecimal(200)), 10002);
        int newId = created.id();
        Dish newDish = new Dish(null,"Новая еда",new BigDecimal(200));
        newDish.setId(newId);
        DISH_TEST_MATHER1.assertMatch(created, newDish);
        DISH_TEST_MATHER1.assertMatch(service.get(newId, 10002), newDish);
    }

    @Test
    void get() throws Exception {
        Dish actual = service.get(10008, 10002);
        DISH_TEST_MATHER1.assertMatch(actual, DISH_L1);
    }
    @Test
    void update() throws Exception {
        Dish updated = new Dish(10008,"updated",new BigDecimal(500));
        service.update(updated, 10002);
        DISH_TEST_MATHER1.assertMatch(service.get(10008, 10002),new Dish(10008,"updated",new BigDecimal(500)) );
    }

    @Test
    void getAll() throws Exception {
        DISH_TEST_MATHER1.assertMatch(service.getAll(10002), DISH_LIST_L);
    }
}