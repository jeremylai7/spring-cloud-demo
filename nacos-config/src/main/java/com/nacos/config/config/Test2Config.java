package com.nacos.config.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: laizc
 * @Date: Created in 16:43 2020-01-17
 */
@Component
@Getter
public class Test2Config {

    //@NacosValue 已经弃用，建议使用 @Value 注解
    @NacosValue(value = "${test.name:null}",autoRefreshed = true)
    private String test;

    @Value(value = "${test.name:#{null}}")
    private String test2;

    // 执行配置文件，就不会读默认配置文件
    @Value(value = "${hello.name:#{null}}")
    private String hello;

    @Value(value = "${common.name:#{null}}")
    private String commonName;









}
