package com.dilshan.fuel.service;

import com.dilshan.fuel.model.Fuel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {
    int fuelCapacity = 10000;
    String orderCapacity;
    String orderId;
    String orderType;
    String orderName;

    @Autowired
    CreateOrder createOrder;

//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;


//    public InventoryService(KafkaTemplate<String, String> kafkaTemplate){
//        this.kafkaTemplate=kafkaTemplate;
//    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "fuelCapacity",groupId = "fid")
    void listener(String  data){
//        System.out.println(data);
        try {
            JSONObject object = new JSONObject(data);
            orderName=object.getString("f_name");
            orderType=object.getString("f_type");
            orderCapacity=object.getString("f_capacity");
            orderId = object.getString("f_id");
            System.out.println(object.getString("f_name"));
            if(fuelCapacity >= Integer.valueOf(orderCapacity)){
                fuelCapacity=fuelCapacity- Integer.valueOf(orderCapacity);
                System.out.println("Fuel Capacity "+orderCapacity);
                System.out.println(fuelCapacity+" remaining the stock");
               // kafkaTemplate.send("orderComplete","Your order create Successfully !!!!");
                createOrder.save(new Fuel(Integer.valueOf(orderId),orderName,Integer.valueOf(orderCapacity),orderType));
            }else{
                System.out.println("Fuel Capacity Not Enough");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
