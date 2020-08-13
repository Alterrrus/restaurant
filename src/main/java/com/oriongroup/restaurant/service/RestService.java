package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.Restaurant;
import com.oriongroup.restaurant.repository.JPA.RestaurantRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestService {
   protected final Logger log= LoggerFactory.getLogger(getClass());
    private final RestaurantRepo restRepo;
    @Autowired
    public RestService(RestaurantRepo restRepo) {
        this.restRepo = restRepo;
    }

    public List<Restaurant>getAll(){
        log.info("getAll");
        List<Restaurant> r=restRepo.getAll();
        r.forEach(a->log.info("id:"+a.id()+" name:"+a.getName()));

        return r;
    }

    public List<Restaurant> findAllWithDishList(){
        log.info("findAllWithDishList");

       /* r.forEach(a->{
            log.info(a.getName()+"\n"+"-----------------------");
            a.getDishList().forEach(z->log.info(z.getName()));});*/
        return restRepo.findAllWithDishListByIdNotNull();}

        public Restaurant get(Integer id){
            log.info("GET");
            return checkNotFoundWithId(restRepo.get(id),id);
        }

        public Restaurant create(Restaurant restaurant){
            log.info("create");
            Assert.notNull(restaurant,"restaurant must not be null");
            return restRepo.save(restaurant);
        }
        public void update(Restaurant restaurant){
            log.info("update");
            Assert.notNull(restaurant,"restaurant must not be null");
            checkNotFoundWithId(restRepo.save(restaurant),restaurant.id());
            log.info(restaurant.getClass().getSimpleName()+":name:"+restaurant.getName());
        }
        public void delete( int id){
            log.info("delete");
        checkNotFoundWithId(restRepo.delete(id),id);
        }



}
