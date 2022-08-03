package com.dilshan.fuel.controller;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.service.CreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class FuelController {

    @Autowired
    CreateOrder createOrder;

    @RequestMapping(value = "/createorder",method = RequestMethod.POST)
    public Fuel save(@RequestBody Fuel fuel){

        return createOrder.save(fuel);
    }
}
