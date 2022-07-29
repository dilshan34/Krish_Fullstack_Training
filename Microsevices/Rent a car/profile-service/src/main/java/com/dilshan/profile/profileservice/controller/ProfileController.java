package com.dilshan.profile.profileservice.controller;

import com.dilshan.model.Customer;
import com.dilshan.model.Vehicle;
import com.dilshan.profile.profileservice.service.CustomerService;
import com.dilshan.profile.profileservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
public Customer save(@RequestBody Customer customer){

    return customerService.save(customer);
}

@Autowired
VehicleService vehicleService;

@RequestMapping(value = "/vehicle",method = RequestMethod.POST)
    public Vehicle save(@RequestBody Vehicle vehicle){

    return vehicleService.save(vehicle);
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Customer fetch(@RequestParam int profileId) {
        return customerService.fetchById(profileId);
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }
}
