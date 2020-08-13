package com.oriongroup.restaurant.repository.extendDataJpa;

import com.oriongroup.restaurant.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface VoteJPA extends JpaRepository<Vote,Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.restaurant.id=:restaurantId AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.restaurant.id=:restaurantId")
    List<Vote> getAll(@Param("restaurantId") int restaurantId);



}
