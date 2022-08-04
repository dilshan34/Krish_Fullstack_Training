package com.dilshan.fuel.config;

import com.dilshan.fuel.model.Fuel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListener {
    int fuelCapacity = 10000;
    String orderCapacity;

    //@org.springframework.kafka.annotation.KafkaListener(topics = "fuelCapacity",groupId = "fid")
    void listener(String  data){
        System.out.println(data);
        try {
            JSONObject object = new JSONObject(data);
            orderCapacity=object.getString("f_capacity");
            System.out.println(object.getString("f_name"));
                    if(fuelCapacity >= Integer.valueOf(orderCapacity)){
            fuelCapacity=fuelCapacity- Integer.valueOf(orderCapacity);
            System.out.println("Fuel Capacity "+orderCapacity);
            System.out.println(fuelCapacity+" remaining the stock");
        }else{
            System.out.println("Fuel Capacity Not Enough");
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

//    int fuelCapacity = 10000;
//
//    @org.springframework.kafka.annotation.KafkaListener(topics = "fuelCapacity",groupId = "fid")
//    void listener(String data){
//        if(fuelCapacity >= Integer.valueOf(data)){
//            fuelCapacity=fuelCapacity- Integer.valueOf(data);
//            System.out.println("Fuel Capacity "+data);
//            System.out.println(fuelCapacity+" remaining the stock");
//        }else{
//            System.out.println("Fuel Capacity Not Enough");
//        }
//
//    }
}
