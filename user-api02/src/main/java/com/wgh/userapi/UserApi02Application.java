package com.wgh.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供端
 *
 * Created by wgh on 2021/3/22.
 */
@EnableEurekaClient
@SpringBootApplication
public class UserApi02Application {

    public static void main(String[] args) {
        SpringApplication.run(UserApi02Application.class, args);
    }
}