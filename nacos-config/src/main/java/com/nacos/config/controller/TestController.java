package com.nacos.config.controller;

import com.nacos.config.config.Test2Config;
import com.nacos.config.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TestController {

    @Autowired
    private Test2Config test2Config;

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/config")
    public String testConfig(){
        String test1 = test2Config.getTest();
        // 不自动刷新
        String test2 = test2Config.getTest2();
        // 自动刷新配置
        String test3 = testConfig.getName();
        //@NacosValue 在2.0以及后续版本弃用
        return "第一种方式:" + test1  + ", 第二种方式:" + test2 + "" +
                ",第三种方式:" + test3 + ", hello:" + test2Config.getHello();
    }
}
