package com.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ComsumeSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComsumeSeataApplication.class, args);
    }

}