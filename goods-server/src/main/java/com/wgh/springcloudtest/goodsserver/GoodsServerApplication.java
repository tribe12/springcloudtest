package com.wgh.springcloudtest.goodsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wgh on 2021/3/27.
 */
@EnableEurekaClient
@SpringBootApplication
public class GoodsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServerApplication.class, args);
    }

}
