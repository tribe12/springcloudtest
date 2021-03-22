package com.wgh.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wgh on 2021/3/22.
 */
@EnableEurekaClient
@SpringBootApplication
public class UserApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiServerApplication.class, args);
    }
}
