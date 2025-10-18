package com.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.stock.dao")
public class NacosStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosStockApplication.class, args);
    }

}
