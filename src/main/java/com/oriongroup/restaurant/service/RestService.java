package com.oriongroup.restaurant.service;

import com.oriongroup.restaurant.model.Restaurant;
import com.oriongroup.restaurant.repository.JPA.RestaurantRepo;
import com.oriongroup.restaurant.repository.JPA.VoteRepo;
import com.oriongroup.restaurant.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestService {
   protected final Logger log= LoggerFactory.getLogger(getClass());
    private final RestaurantRepo restRepo;
    private final VoteRepo voteRepo;
    @Autowired
    public RestService(RestaurantRepo restRepo, VoteRepo voteRepo) {
        this.restRepo = restRepo;
        this.voteRepo = voteRepo;
    }

    public List<Restaurant>getAll(){
        log.info("getAll");
        LocalDate start=LocalDateTime.now().toLocalDate();
        LocalDateTime start1=LocalDate.now().atStartOfDay();
        LocalDateTime start2=LocalDate.now().atTime(23,59,59);
        log.info(start.toString());
        log.info(start1.toString());
        log.info(start2.toString());
        List<Restaurant> r=restRepo.getAll();
        r.forEach(a->log.info("id:"+a.id()+" name:"+a.getName()));

        return r;
    }

    public List<Restaurant> findAllWithDishList(){
        return restRepo.findAllWithDishListByIdNotNull();}

    public List<Restaurant>findAllWithDishAndVote(){
        List<Restaurant>listWithDish=restRepo.findAllWithDishListByIdNotNull();
        listWithDish.forEach(a->{a.setVoteList(voteRepo.getAll(a.id()));});
        return listWithDish;
    }

        public Restaurant get(Integer id){
            log.info("GET");
            return checkNotFoundWithId(restRepo.get(id),id);
        }

        public Restaurant create(Restaurant restaurant){
            log.info("create new restaurant");
            Assert.notNull(restaurant,"restaurant must not be null");
            return restRepo.save(restaurant);
        }
        public void update(Restaurant restaurant,int id){
            log.info("update restaurant");
            ValidationUtil.assureIdConsistent(restaurant,id);
            Assert.notNull(restaurant,"restaurant must not be null");
            checkNotFoundWithId(restRepo.save(restaurant),restaurant.id());
            log.info(restaurant.getClass().getSimpleName()+":name:"+restaurant.getName());
        }
        public void delete( int id){
            log.info("delete restaurant");
        checkNotFoundWithId(restRepo.delete(id),id);
        }



}
