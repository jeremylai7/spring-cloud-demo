package com.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
		name.toString();
		return "hello4  " + name + " port:" + environment.getProperty("local.server.port");
	}
}
