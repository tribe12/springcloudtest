package com.wgh.springcloudtest.userweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务消费端
 *
 * Created by wgh on 2021/3/22.
 */
//@RibbonClient("USER-API")
//@EnableEurekaClient
@EnableDiscoveryClient//此处只是为了体现服务发现的效果，实际开发中不使用 DiscoveryClient 查询服务进行调用！至于如何进行服务发现和调用可以使用Ribbon.
@SpringBootApplication
public class UserWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication.class, args);
    }
}
