package com.wgh.springcloudtest.orderserver.service;


import com.wgh.springcouldtest.commonapi.model.Order;

public interface OrderService {

	void placeOrder(Order order) throws Exception;
}
