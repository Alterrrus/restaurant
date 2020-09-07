package com.oriongroup.restaurant.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    @Digits(integer = 5,fraction = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId",nullable = false,referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "dishList")
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;

    }

    public Dish(String name, BigDecimal price) {
        this(null, name, price);
    }



    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
