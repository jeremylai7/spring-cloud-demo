package com.nacos.consume.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: laizc
 * @Date: 2020/1/16 22:03
 * @Description:
 */
@FeignClient(value = "service-provider",fallback = HelloRemoteHystrix.class)
public interface ProductClient {

    @GetMapping("/hello")
    String product(@RequestParam("name") String name);
}
