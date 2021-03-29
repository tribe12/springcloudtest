package com.wgh.springcloudtest.orderserver.controller;

import com.wgh.springcloudtest.orderserver.service.OrderService;
import com.wgh.springcouldtest.commonapi.model.Order;
import com.wgh.springcouldtest.commonapi.model.User;
import com.wgh.springcouldtest.commonapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/place")
    public Result placeOrder(Order order) throws Exception {

        return this.orderService.placeOrder(order);
    }


    @RequestMapping("/get")
    public Result get(Order order) throws Exception {
        String url = "http://USER-API/provider/user/get/" + 1;
        return Result.success(restTemplate.getForObject(url, User.class));
    }


}
