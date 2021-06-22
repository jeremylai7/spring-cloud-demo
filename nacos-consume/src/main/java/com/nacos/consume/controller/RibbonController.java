package com.nacos.consume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-09
 * @desc: 使用 ribbon 进行服务调用
 */
@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ribbon")
	public String ribbon(String name){
		String result = restTemplate.getForObject("http://service-provider/hello?name="+name,String.class);
		return result;
	}
}
