package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient//开启Eureka客户端获取发现服务的能力
@SpringBootApplication
public class RibbonConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerApplication.class, args);
	}
	
	@Bean//随着服务的启动方法被调用 生产一个bean
	@LoadBalanced//客户端负载均衡
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
