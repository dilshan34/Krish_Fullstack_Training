package com.dilshan.profile.profileservice.service;

import com.dilshan.model.Vehicle;
import com.dilshan.profile.profileservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface VehicleService {



    Vehicle save(Vehicle vehicle);
}
