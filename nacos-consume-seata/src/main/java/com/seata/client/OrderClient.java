package com.seata.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: laizc
 * @date: created in 2022/10/17
 * @desc:
 **/
@FeignClient(value = "nacos-provide-order")
public interface OrderClient {

    @GetMapping("/order")
    public String order();
}
