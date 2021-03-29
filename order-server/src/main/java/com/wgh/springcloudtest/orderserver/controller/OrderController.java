package com.wgh.springcloudtest.orderserver.controller;

import com.wgh.springcloudtest.orderserver.service.GoodsFeignClientService;
import com.wgh.springcloudtest.orderserver.service.OrderService;
import com.wgh.springcouldtest.commonapi.model.Order;
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
    @Autowired
    private GoodsFeignClientService goodsFeignClientService;

    @RequestMapping("/place")
    public Result placeOrder(Order order) throws Exception {
        return this.orderService.placeOrder(order);
    }


    @RequestMapping("/placefc")
    public Result placeOrderByFeignClient(Order order) throws Exception {
        System.out.println("/order/placefc:"+ order);
        Result result = this.goodsFeignClientService.goodsInfo(order.getGoodsId());
        System.out.println("result:"+result);
        return result;
    }

}
