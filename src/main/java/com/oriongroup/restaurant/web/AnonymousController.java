package com.oriongroup.restaurant.web;


import com.oriongroup.restaurant.model.Restaurant;
import com.oriongroup.restaurant.service.RestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnonymousController {
    private final RestService restService;

    public AnonymousController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurantWithDishAndVote() {
        return restService.findAllWithDishAndVote();
    }

}
