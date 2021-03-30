package com.wgh.springcloudtest.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.wgh.springcloudtest"})//为了能扫描common-api项目中的GoodsServiceFeignClientFallbackFactory
@EnableCircuitBreaker//开启熔断功能
@EnableFeignClients(basePackages = {"com.wgh.springcloudtest"})//能扫描common-api项目中的GoodsServiceFeignClient
@EnableEurekaClient
@SpringBootApplication
public class OrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}
}
