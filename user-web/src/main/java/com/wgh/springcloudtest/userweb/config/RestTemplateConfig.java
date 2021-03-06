package com.wgh.springcloudtest.userweb.config;

/**
 * Created by wgh on 2021/3/22.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;





/**
 * RestTemplate配置
 * 这是一种JavaConfig的容器配置，用于spring容器的bean收集与注册，并通过参数传递的方式实现依赖注入。
 * "@Configuration"注解标注的配置类，都是spring容器配置类，springboot通过"@EnableAutoConfiguration"
 * 注解将所有标注了"@Configuration"注解的配置类，"一股脑儿"全部注入spring容器中。
 *
 * @author mht
 *
 */
@Configuration
public class RestTemplateConfig {

//    private RestTemplate restTemplate;
    private ClientHttpRequestFactory factory;

    @Autowired
    public void setFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        this.factory = factory;
    }

//    @Autowired
//    public void setRestTemplate() {
//        this.restTemplate = new RestTemplate(this.factory);
//    }

//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }

}
