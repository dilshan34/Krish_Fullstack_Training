package com.dilshan.fuel.config;

import com.dilshan.fuel.model.Fuel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "fuelCapacity",groupId = "fid")
    void listener(String  data){
        System.out.println(data);
        try {
            JSONObject object = new JSONObject(data);
            System.out.println(object.getString("f_name"));
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
