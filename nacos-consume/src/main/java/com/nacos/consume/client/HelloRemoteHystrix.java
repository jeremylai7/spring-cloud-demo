package com.nacos.consume.client;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/6/22
 * @desc:
 **/
@Component
public class HelloRemoteHystrix implements ProductClient{

    @Override
    public String product(String name) {
        return "哎呦喂，服务崩溃了，请再试一次" + name;
    }

    @Override
    public List<Long> testFeignGetCallPost(List<Long> list) {
        return Collections.emptyList();
    }
}
