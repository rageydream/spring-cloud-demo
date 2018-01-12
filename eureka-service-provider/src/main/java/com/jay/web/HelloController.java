package com.jay.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId() + ",uri:"
				+ instance.getUri());
		//结果：/hello,host:jay-pc.lan,service_id:hello-service,uri:http://jay-pc.lan:2222
		return "hello";
	}
}
