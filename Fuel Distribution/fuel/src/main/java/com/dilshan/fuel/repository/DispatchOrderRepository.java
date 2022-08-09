package com.dilshan.fuel.repository;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.model.SubmitOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DispatchOrderRepository extends JpaRepository<Fuel,Integer> {

    @Query("FROM Fuel  WHERE dispatch= 0 ")
    List<Fuel> findAll();

    @Query("from Fuel where f_id=:f_id")
    List<Fuel> findById(@Param("f_id") int id);

    @Query("FROM Fuel  WHERE dispatch= 1 ")
    List<Fuel> findAllOrders();




}
