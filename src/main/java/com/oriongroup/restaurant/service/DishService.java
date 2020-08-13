package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.Dish;
import com.oriongroup.restaurant.repository.JPA.DishRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService extends AbstractService {
    protected final Logger log= LoggerFactory.getLogger(getClass());
    private final DishRepo dishRepo;


    public DishService(DishRepo dishRepo) {
        this.dishRepo = dishRepo;
    }

    public Dish get(int id,int restaurantId){
        log.info("GET");
        return checkNotFoundWithId(dishRepo.get(id,restaurantId),id);
    }
    public void delete(int id,int  restaurantId){
        log.info("DELETE");
        checkNotFoundWithId(dishRepo.delete(id,restaurantId),id);
    }
    public List<Dish> getAll(int restaurantId){
        log.info("GETALL");
        return dishRepo.getAll(restaurantId);
    }

    public void update(Dish dish, int restaurantId) {
        log.info("UPDATE");
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(dishRepo.save(dish, restaurantId), dish.id());
    }

    public Dish create(Dish dish, int restaurantId) {
        log.info("CREATE");
        Assert.notNull(dish, "dish must not be null");
        return dishRepo.save(dish, restaurantId);
    }
}
