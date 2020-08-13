package com.oriongroup.restaurant.web;

import com.oriongroup.restaurant.service.RestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {
    private final RestService service;


    public RestaurantController(RestService service) {
        this.service = service;
    }
}
