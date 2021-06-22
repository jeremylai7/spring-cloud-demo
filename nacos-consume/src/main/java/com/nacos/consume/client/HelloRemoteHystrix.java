package com.nacos.consume.client;

import org.springframework.stereotype.Component;

/**
 * @author: laizc
 * @date: created in 2021/6/22
 * @desc:
 **/
@Component
public class HelloRemoteHystrix implements ProductClient{

    @Override
    public String product(String name) {
        return "network is faile " + name;
    }
}
