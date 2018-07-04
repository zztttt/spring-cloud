package com.springcloud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
 
	private static Logger log = LoggerFactory.getLogger(ConsumerController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
    String port;
	
	@Value("${spring.application.name}")
    String appname;
	
	@RequestMapping("consumer")
	@HystrixCommand(fallbackMethod = "hiError")
	public String consumer(@RequestParam String name){
		log.info(String.format("%s >>> %s",appname,"http://HELLO-SERVICE/hello"+"?name="+name));
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello"+"?name="+name, String.class).getBody();
	}
	
	@RequestMapping("from")
	public String consumer1(){
		log.info(String.format("%s >>> %s",appname,"Hello, I am ribbon at port "+port));
		return "Hello, I am ribbon at port "+port;
	}
	
	public String hiError(@RequestParam String name) {
		log.warn(String.format("%s >>> %s",appname,"service hello failed, feedback"));
        return "oops! sorry "+name+",error!";
    }
	
}
