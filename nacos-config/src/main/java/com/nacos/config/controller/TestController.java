package com.nacos.config.controller;

import com.nacos.config.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: laizc
 * @Date: 2020/1/17 22:52
 * @Description:
 */
@RestController
public class TestController {

    @Value(value = "${test:null}")
    private String test;

    @Autowired
    private TestConfig testConfig;

    /**
     * 使用@NacosValues可以自动更新配置
     * 使用@Value不能自动更新配置
     * @return
     */
    @GetMapping("/config")
    public String testConfig(){
        String aa = testConfig.getTest();
        return "第一种方式:" + aa  + ",第二种方式:" + test + ",第三种方式：" + testConfig.getTest2();
    }
}
