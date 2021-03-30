package com.wgh.springcloudtest.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 除了服务熔断、降级的功能外，Hystrix 还提供了准及时的调用监控。
 * Hystrix 会持续地记录所有通过 Hystrix 发起的请求的执行信息，
 * 并以统计报表和图形方式展示给用户。
 *
 *
 *  启动后访问地址：
 *      http://localhost:9300/hystrix
 *  填写说明：
 *      需要监控的服务地址： http://localhost:8100/actuator/hystrix.stream
 *      delay: 请求间隔时间
 *      title: 监控名称
 *      点击 monitor stream
 *      批量访问 order-server 服务的下单接口。
 *
 *
 *  图形查看监控信息：
 *      实心圆：通过颜色的变化代表实例的健康程度，健康度从绿色>黄色>橙色>红色递减。
 *             其大小也会根据实例的请求流量发生变化，流量越大实心圆越大。
 *      曲线：用来记录间隔时间内流量的相对变化，通常可以观察到流量的上升和下降趋势。
 *
 * Created by wgh on 2021/3/30.
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
