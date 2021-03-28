package com.wgh.springcloudtest.orderserver.service.impl;

import com.wgh.springcloudtest.orderserver.service.OrderService;
import com.wgh.springcouldtest.commonapi.model.Order;
import com.wgh.springcouldtest.commonapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private DiscoveryClient client;

	@Override
	public Result placeOrder(Order order) throws Exception{
		
		// 获取商品服务地址列表
//		List<ServiceInstance> list = this.client.getInstances("GOODS");
//		String uri = "";
//	    for (ServiceInstance instance : list) {
//	        if (instance.getUri() != null && !"".equals(instance.getUri())) {
//	        	uri = instance.getUri().toString();
//	        	break;
//	        }
//	    }
//	    
//		Result result = restTemplate.getForObject(new URI(uri + "/goods/goodsInfo/" + order.getGoodsId()), Result.class);
		
		Result result = this.restTemplate.getForObject("http://GOODS/goods/goodsInfo/" + order.getGoodsId(), Result.class);
		
		if (result != null && result.getCode() == 200) {
			System.out.println("=====下订单====");
			System.out.println(result.getData());
		}

		return result;
	}

}
