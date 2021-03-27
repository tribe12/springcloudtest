package com.wgh.springcloudtest.orderserver.controller;

import com.wgh.springcloudtest.orderserver.service.OrderService;
import com.wgh.springcouldtest.commonapi.model.Order;
import com.wgh.springcouldtest.commonapi.vo.Result;
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
		
		this.orderService.placeOrder(order);
		return Result.success();
	}
}
