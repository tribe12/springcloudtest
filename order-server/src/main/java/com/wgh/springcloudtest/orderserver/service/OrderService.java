package com.wgh.springcloudtest.orderserver.service;


import com.wgh.springcloudtest.commonapi.model.Order;
import com.wgh.springcloudtest.commonapi.vo.Result;

public interface OrderService {

    Result placeOrder(Order order) throws Exception;

    void placeOrderAllError() throws Exception;

    Result placeOrderByFeignClient(Order order);
}
