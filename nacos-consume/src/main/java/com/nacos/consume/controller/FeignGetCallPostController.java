package com.nacos.consume.controller;

import com.nacos.consume.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2026/9/9
 * @desc:
 **/
@RestController
@RequestMapping("/get-call-post")
public class FeignGetCallPostController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/test")
    public List<Long> testFeignGetCallPost() {
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        return productClient.testFeignGetCallPost(list);
    }
}
