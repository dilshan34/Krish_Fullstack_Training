package com.dilshan.rentcarcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class RentcarcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentcarcloudApplication.class, args);
    }

}
