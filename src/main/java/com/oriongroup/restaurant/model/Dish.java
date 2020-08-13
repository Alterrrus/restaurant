package com.oriongroup.restaurant.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity
@Table(name = "dish")
public class Dish extends AbstractBaseEntity {
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "price")
    @NotNull
    private BigDecimal price;
    @Column(name = "restaurantId")
    @NotNull
    private Integer restaurantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId",nullable = false,referencedColumnName = "id",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, BigDecimal price, Integer restaurantId) {
        super(id);
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public Dish(String name, BigDecimal price, Integer restaurantId) {
        this(null, name, price, restaurantId);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
