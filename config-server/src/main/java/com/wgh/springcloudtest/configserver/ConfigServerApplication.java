package com.wgh.springcloudtest.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Config 用于为分布式系统中的基础设施
 * 和微服务应用提供集中化的外部配置支持，它分为服务端
 * 和客户端两部分。服务端（config server）也称为分布
 * 式配置中心，是一个独立的微服务应用，用来连接配置仓
 * 库并为客户端提供获取配置信息，加密/解密信息等访问接
 * 口。而客户端（config client）则是微服务架构中各微
 * 服务应用或基础设施，通过指定的配置中心来管理应用资
 * 源与业务相关的配置内容，并在启动的时候从配置中心获
 * 取和加载配置信息。
 * Created by wgh on 2021/4/1.
 */

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
