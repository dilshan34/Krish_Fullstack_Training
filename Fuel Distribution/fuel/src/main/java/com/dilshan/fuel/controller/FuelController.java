package com.dilshan.fuel.controller;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.service.CreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class FuelController {

    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    CreateOrder createOrder;

//    @RequestMapping(value = "/createorder",method = RequestMethod.POST)
//    public Fuel save(@RequestBody Fuel fuel){
//
//        return createOrder.save(fuel);
//    }

    public FuelController(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    @RequestMapping(value = "/createorder",method = RequestMethod.POST)
    public void publish(@RequestBody Fuel fuel){

        kafkaTemplate.send("kafka",fuel.getF_name());
        kafkaTemplate.send("kafka", String.valueOf(fuel.getF_capacity()));
        createOrder.save(fuel);

    }


}
