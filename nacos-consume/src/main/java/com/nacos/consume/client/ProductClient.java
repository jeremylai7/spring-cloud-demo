package com.nacos.consume.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther: laizc
 * @date: 2020/1/16 22:03
 * @desc:
 */
@FeignClient(value = "service-provider")
public interface ProductClient {

    @GetMapping("/hello")
    String product(@RequestParam("name") String name);
}
