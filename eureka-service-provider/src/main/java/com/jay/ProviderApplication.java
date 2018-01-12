package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//开启Eureka客户端  来发现、注册服务
@SpringBootApplication
public class ProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
}
