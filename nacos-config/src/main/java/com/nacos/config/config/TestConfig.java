package com.nacos.config.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: laizc
 * @date: 2025/12/15 16:33
 * @desc:
 */
@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestConfig {

    private String name;

    private String password;

}
