package com.seata.proxy.feign;

import com.common.Test;
import com.common.constant.ServiceNameConstant;
import com.common.wrapper.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2022/10/17
 * @desc:
 **/
@FeignClient(value = ServiceNameConstant.NACOS_PROVIDE_STOCK)
public interface StockFeign {

    @GetMapping("/stock")
    BaseResponse<String> stock(@RequestParam("num") Integer num);

    @GetMapping("/tcc/stock")
    BaseResponse<Test> tccStock(@RequestParam("num") BigDecimal num);

}
