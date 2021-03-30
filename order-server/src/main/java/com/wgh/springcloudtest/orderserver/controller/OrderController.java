package com.wgh.springcloudtest.orderserver.controller;

import com.wgh.springcloudtest.commonapi.model.Order;
import com.wgh.springcloudtest.commonapi.vo.Result;
import com.wgh.springcloudtest.orderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/place")
    public Result placeOrder(Order order) throws Exception {
        System.out.println("=====================================place");
        System.out.println("/order/place:" + order);
        return this.orderService.placeOrder(order);
    }


    @RequestMapping("/placefc")
    public Result placeOrderByFeignClient(Order order) throws Exception {
        System.out.println("=====================================placefc");
        System.out.println("/order/placefc:" + order);
        return this.orderService.placeOrderByFeignClient(order);
    }


    @RequestMapping("/placeerror")
    public Result placeOrdeError(Order order) throws Exception {
        System.out.println("=====================================placeerror");
        order.setGoodsId("7");
        System.out.println("/order/place:" + order);
        return this.orderService.placeOrder(order);
    }

    @RequestMapping("/placeallerror")
    public Result placeOrderAllError(Order order) throws Exception {
        System.out.println("=====================================placeallerror");
        System.out.println("/order/place:" + order);
        this.orderService.placeOrderAllError();
        return Result.fail();
    }
}
