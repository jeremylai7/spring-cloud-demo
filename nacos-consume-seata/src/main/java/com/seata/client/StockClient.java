package com.seata.client;

import com.common.Test;
import com.common.wrapper.BaseResponse;
import com.common.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

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
    BaseResponse<Test> tccStock(@RequestParam("num") BigDecimal num);

}
