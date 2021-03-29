package com.wgh.springcloudtest.orderserver.service;


import com.wgh.springcouldtest.commonapi.model.Order;
import com.wgh.springcouldtest.commonapi.vo.Result;

public interface OrderService {

    Result placeOrder(Order order) throws Exception;

    void placeOrderAllError() throws Exception;
}
