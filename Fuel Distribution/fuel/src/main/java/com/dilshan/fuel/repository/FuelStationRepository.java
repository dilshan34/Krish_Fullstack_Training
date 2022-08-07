package com.dilshan.fuel.repository;

import com.dilshan.fuel.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelStationRepository extends JpaRepository<Fuel,Integer> {

}
