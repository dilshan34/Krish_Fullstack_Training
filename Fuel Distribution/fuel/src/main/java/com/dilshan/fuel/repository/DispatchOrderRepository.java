package com.dilshan.fuel.repository;

import com.dilshan.fuel.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispatchOrderRepository extends JpaRepository<Fuel,Integer> {

    @Query("FROM Fuel  WHERE dispatch= 0 ")
    List<Fuel> findAll();
    List<Fuel> findById(int id);

    @Query("FROM Fuel  WHERE dispatch= 1 ")
    List<Fuel> findAllOrders();

}
