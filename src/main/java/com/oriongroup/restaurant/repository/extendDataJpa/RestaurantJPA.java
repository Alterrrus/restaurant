package com.oriongroup.restaurant.repository.extendDataJpa;

import com.oriongroup.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RestaurantJPA extends JpaRepository<Restaurant,Integer> {

    @EntityGraph(attributePaths = {"dishList"},type=EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Restaurant  AS r ")
    List<Restaurant> findAllWithDishListByIdNotNull();

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);



}
