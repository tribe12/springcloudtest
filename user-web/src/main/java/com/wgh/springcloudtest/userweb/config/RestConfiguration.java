package com.wgh.springcloudtest.userweb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wgh on 2021/3/22.
 */
//@RibbonClient("USER-API")
@Configuration
public class RestConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}