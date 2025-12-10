package com.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {
        "com.seata",    // 自己原来的包
        "com.common"    // 把 common 模块的包也扫进来
})
public class ComsumeSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComsumeSeataApplication.class, args);
    }

}
