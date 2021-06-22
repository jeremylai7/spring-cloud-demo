package com.nacos.consume.controller;

import com.nacos.consume.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: laizc
 * @Date: 2020/1/16 21:07
 * @Description: 使用 Feign 进行服务调用
 */
@RestController
public class FeignController {


    //这个错误是编译器问题。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private ProductClient productClient;

    @GetMapping("/feign")
    public String feign(String name){
        return productClient.product(name);
    }





}
