package com.dilshan.fuel.service;

import com.dilshan.fuel.model.Fuel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {
    int petrol95 = 100_000;
    int petrol92 = 100_000;
    int diesel = 100_000;
    int superDiesel = 100_000;
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
            int capacity = Integer.valueOf(orderCapacity);

            Fuel saveOrder = new Fuel(Integer.valueOf(orderId),orderName,Integer.valueOf(orderCapacity),orderType);

            if (orderType.equals("92 petrol") && petrol92 >= capacity ){
                petrol92=petrol92-capacity;
                createOrder.save(saveOrder);
            }else if(orderType.equals("95 petrol") && petrol95 >= capacity){
                petrol95=petrol95-capacity;
                createOrder.save(saveOrder);
            }else if(orderType.equals("Diesel") && diesel >= capacity){
                diesel=diesel-capacity;
                createOrder.save(saveOrder);
            }else if(orderType.equals("Super Diesel") && superDiesel >= capacity){
                superDiesel=superDiesel-capacity;
                createOrder.save(saveOrder);
            }
            
        else{
                System.out.println("Fuel Capacity Not Enough");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
