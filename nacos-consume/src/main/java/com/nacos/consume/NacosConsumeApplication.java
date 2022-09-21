package com.nacos.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumeApplication {

    public static void main(String[] args) {
        new SpringApplication(NacosConsumeApplication.class).run(args);
        Set<String> set =new HashSet<>();
        set.add("aa");

        //SpringApplication.run(NacosConsumeApplication.class, args);
    }

}
