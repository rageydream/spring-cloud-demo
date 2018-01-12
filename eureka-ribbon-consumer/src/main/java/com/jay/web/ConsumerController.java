package com.jay.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//注入restTemplate
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String consumer() {
		//调用eureka-service提供的服务   Eureka 通过Rest API来调用服务，Dubbo为RPC ,这里用的 服务名 而不是ip
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
}
