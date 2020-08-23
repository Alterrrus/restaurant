package com.oriongroup.restaurant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractBaseEntity{
    @Column(name = "name")
    @NotNull
    private String name;


    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    @JsonManagedReference(value = "voteList")
    private List<Vote> voteList;

    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    @JsonManagedReference(value = "dishList")
    private List<Dish> dishList;

    public Restaurant(){}

    public Restaurant(String name){
        this.name=name;
    }



    public Restaurant(String name, List<Vote> voteList, List<Dish> dishList) {
        this.name = name;
        this.voteList = voteList;
        this.dishList = dishList;
    }

    public Restaurant(Integer id, List<Vote> voteList, List<Dish> dishList,String name) {
        super(id);
        this.voteList = voteList;
        this.dishList = dishList;
        this.name=name;
    }
    public Restaurant(Restaurant r){
        this(r.getId(),r.getVoteList(),r.getDishList(),r.getName());
    }

    public String getName() {
        return name;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }


}
