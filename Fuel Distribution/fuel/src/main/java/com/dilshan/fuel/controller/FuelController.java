package com.dilshan.fuel.controller;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.model.SubmitOrder;
import com.dilshan.fuel.repository.AllOrderRepository;
import com.dilshan.fuel.service.CreateOrderService;
import com.dilshan.fuel.service.FetchOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class FuelController {

    @Autowired
    private KafkaTemplate<String, Fuel> kafkaTemplate;
    @Autowired
    CreateOrderService createOrderService;
    @Autowired
    FetchOrder fetchOrderService;
    @Autowired
    AllOrderRepository allOrderRepository;

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

    @RequestMapping(value = "/submitOrder",method = RequestMethod.PUT)
    public  SubmitOrder save(@RequestBody SubmitOrder submitOrder){
        return allOrderRepository.save(submitOrder);
    }


        @RequestMapping(value = "/dispatchorders",method = RequestMethod.GET)

    public List<Fuel> fetch(){
        return fetchOrderService.fetchAllOrders();
    }

    @RequestMapping(value = "/allorders",method = RequestMethod.GET)

    public List<Fuel> fetchAllOrders(){
        return fetchOrderService.AllOrders();
    }


    @GetMapping("/checkOrders/{f_id}")
    public List<Fuel> getOrderById(
            @PathVariable(value = "f_id") int id)
    {
        return fetchOrderService.findById(id);
    }
}
