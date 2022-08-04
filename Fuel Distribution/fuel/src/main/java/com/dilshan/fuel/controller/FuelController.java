package com.dilshan.fuel.controller;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.service.CreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class FuelController {

    @Autowired
    private KafkaTemplate<String, Fuel> kafkaTemplate;
    @Autowired
    CreateOrder createOrder;

//    @RequestMapping(value = "/createorder",method = RequestMethod.POST)
//    public Fuel save(@RequestBody Fuel fuel){
//
//        return createOrder.save(fuel);
//    }


    public FuelController(KafkaTemplate<String, Fuel> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    @RequestMapping(value = "/createorder",method = RequestMethod.POST,consumes = {"application/json"},produces = {"application/json"})
    public void publish(@RequestBody Fuel fuel){


        kafkaTemplate.send("fuelCapacity",
                new Fuel(fuel.getF_id(), fuel.getF_name(), fuel.getF_capacity(), fuel.getF_type()));


    }


}
