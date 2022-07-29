package com.dilshan.rentcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class RentCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCloudApplication.class, args);
    }

}
