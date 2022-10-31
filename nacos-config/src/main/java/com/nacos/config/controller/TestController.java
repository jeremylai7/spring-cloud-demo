package com.nacos.config.controller;

import com.nacos.config.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: laizc
 * @Date: 2020/1/17 22:52
 * @Description:
 */
@RestController
@RefreshScope
public class TestController {

    @Value(value = "${user.name:null}")
    private String test;

    @Autowired
    private TestConfig testConfig;

    /**
     * 使用 nacos-config-spring-boot-starter 才能使用@NacosValues配置
     * 使用@Value需要添加@RefreshScope实现自动更新配置
     * @return
     */
    @GetMapping("/config")
    public String testConfig(){
        String aa = testConfig.getTest();
        //第一种方式要添加 nacos-config-spring-boot-starter 才能使用 @NacosValue 注解获取数据
        return "第一种方式:" + aa  + ",第二种方式:" + test + ",第三种方式：" + testConfig.getTest2();
    }
}
