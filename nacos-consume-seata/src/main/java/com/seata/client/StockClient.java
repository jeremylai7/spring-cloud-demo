package com.seata.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: laizc
 * @date: created in 2022/10/17
 * @desc:
 **/
@FeignClient(value = "nacos-provide-stock")
public interface StockClient {

    @GetMapping("/stock")
    String stock(@RequestParam("num") Integer num);

    @GetMapping("/tcc/stock")
    String tccStock(@RequestParam("num") Integer num);

}
