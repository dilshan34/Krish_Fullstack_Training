package com.dilshan.fuel.service;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOrder implements FuelService{

    @Autowired
    FuelStationRepository fuelStationRepository;


    public Fuel save(Fuel fuel) {
      return fuelStationRepository.save(fuel);
    }
}
