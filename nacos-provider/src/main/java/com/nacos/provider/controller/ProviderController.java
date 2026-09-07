package com.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2020-08-19
 * @desc:
 */
@RestController
public class ProviderController {

	@Autowired
	private Environment environment;

	@GetMapping("/hello")
	public String hello(String name){
		//测试熔断器 1.传入非空返回正常值 2、传入空值报错，触发熔断方法
		//name.toString();
		return "hello4  " + name + " port:" + environment.getProperty("local.server.port");
	}

	@PostMapping("/testFeignGetCallPost")
	public List<Long> testPost(@RequestBody List<Long> list){
		System.out.println(list);
		return list;
	}


}
