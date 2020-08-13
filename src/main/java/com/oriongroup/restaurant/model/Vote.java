package com.oriongroup.restaurant.model;

import com.oriongroup.restaurant.util.LocalDateTimePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "vote")
public class Vote extends AbstractBaseEntity{
    @Column(name = "restaurantId",nullable = false)
    private Integer restaurantId;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "timeExist",nullable = false)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime timeExist=LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId",nullable = false, referencedColumnName = "id",insertable = false,updatable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",nullable = false,referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    public Vote(){}

    public Vote(Integer userId,Integer restaurantId) {
        this.restaurantId=restaurantId;
        this.userId = userId;
        this.timeExist=LocalDateTime.now();
    }

    public Vote(Integer id, Integer userId,Integer restaurantId, LocalDateTime timeExist) {
        super(id);
        this.restaurantId=restaurantId;
        this.userId = userId;
        this.timeExist=timeExist;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDateTime getTimeExist() {
        return timeExist;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTimeExist(LocalDateTime timeExist) {
        this.timeExist = timeExist;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
