package com.wgh.springcloudtest.orderserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgh on 2021/4/1.
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${env}")
    private String env; // 从配置中心获取

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo() {
        return env;
    }
}
