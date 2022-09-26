package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.stock.dao")
public class NacosStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosStockApplication.class, args);
    }

}
