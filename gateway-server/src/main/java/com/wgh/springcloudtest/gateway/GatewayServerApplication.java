package com.wgh.springcloudtest.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul
 *
 * 启动后可以访问： http://localhost:9600/order/order/place?goodsId=1
 * 与访问 http://localhost:8100/order/place?goodsId=1效果一样
 *
 *  http://localhost:9600/order/order/place?goodsId=1中第一个 order
 *  表示的是注册在 Eureka 上的订单服务名称。
 *
 *
 * Created by wgh on 2021/3/30.
 */
@EnableZuulProxy
@SpringBootApplication
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
}
