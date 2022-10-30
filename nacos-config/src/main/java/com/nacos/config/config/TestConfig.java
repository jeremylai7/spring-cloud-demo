package com.nacos.config.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: laizc
 * @Date: Created in 16:43 2020-01-17
 */
@Component
@RefreshScope
public class TestConfig {

    @NacosValue(value = "${user.name:null}",autoRefreshed = true)
    private String test;

    @Value(value = "${user.name:null}")
    private String test2;

    public String getTest2() {
        return test2;
    }

    public String getTest(){
        return test;
    }





}
