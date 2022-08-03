package com.dilshan.fuel.config;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "kafka",groupId = "fid")
    void listener(String data){
        System.out.println("Data Received "+data);
    }
}
