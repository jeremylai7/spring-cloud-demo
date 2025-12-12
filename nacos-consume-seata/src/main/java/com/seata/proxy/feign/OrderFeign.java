package com.seata.proxy.feign;

import com.common.constant.ServiceNameConstant;
import com.common.wrapper.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: laizc
 * @date: created in 2022/10/17
 * @desc:
 **/
@FeignClient(value = ServiceNameConstant.NACOS_PROVIDE_ORDER)
public interface OrderFeign {

    @GetMapping("/order")
    BaseResponse<String> order();

    @GetMapping("/orderUpdate")
    BaseResponse<String> orderUpdate();

    @GetMapping("/tcc/order")
    BaseResponse<Long> tccOrder();
}
