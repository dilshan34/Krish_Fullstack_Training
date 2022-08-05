package com.dilshan.fuel.repository;

import com.dilshan.fuel.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispatchOrderRepository extends JpaRepository<Fuel,Integer> {

    List<Fuel> findAll();
}
