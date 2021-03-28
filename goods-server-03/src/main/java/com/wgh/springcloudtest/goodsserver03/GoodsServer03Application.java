package com.wgh.springcloudtest.goodsserver03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GoodsServer03Application {

	public static void main(String[] args) {
		SpringApplication.run(GoodsServer03Application.class, args);
	}
}
