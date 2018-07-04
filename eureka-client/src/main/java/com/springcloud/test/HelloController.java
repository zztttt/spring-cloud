package com.springcloud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Value("${server.port}")
    String port;
	
	@Value("${spring.application.name}")
    String appname;
	
	@RequestMapping("hello")
	public String index(@RequestParam String name){
		log.info(String.format("%s >>> %s",appname,"hello with name "+name));
		return "hello "+ name + ",I am from port:" +port;
	}
	
	@RequestMapping("hi")
	public String index1(){
		log.info(String.format("%s >>> %s",appname,"hi without name"));
		return "hi, I am from port:" +port+", Who are you?";
	}
	
	@RequestMapping("from")
	public String consumer1(){
		log.info(String.format("%s >>> %s",appname,"get from port and server"));
		return "Hello, I am eureka client at port "+port;
	}
}
