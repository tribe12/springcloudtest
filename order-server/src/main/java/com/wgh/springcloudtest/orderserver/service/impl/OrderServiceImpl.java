package com.wgh.springcloudtest.orderserver.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wgh.springcloudtest.orderserver.service.OrderService;
import com.wgh.springcouldtest.commonapi.model.Order;
import com.wgh.springcouldtest.commonapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@DefaultProperties(defaultFallback = "defaultByOrderService")
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

//	@Autowired
//	private DiscoveryClient client;

    @HystrixCommand(fallbackMethod = "defaultByPlaceOrder")
    //@HystrixCommand
    @Override
    public Result placeOrder(Order order) throws Exception {
        //使用DiscoveryClient方式
        //Result result = placeOrderByDiscoveryClient(order);

        //模拟查询出现错误
        if ("7".equals(order.getGoodsId())) {
            int i = 1 / 0;
        }

        Result result = this.restTemplate.getForObject("http://GOODS/goods/goodsInfo/" + order.getGoodsId(), Result.class);

        if (result != null && result.getCode() == Result.SUCCESS_CODE) {
            System.out.println("=====下订单====");
            System.out.println(result.getData());
        }


        return result;
    }

    @HystrixCommand
    @Override
    public void placeOrderAllError() throws Exception {
        int i = 2 / 0;
    }


    /**
     * 熔断后的默认处理方法
     * <p>
     * 当调用商品服务超时或出现异常时，
     * Hystrix 会调用 @HystrixCommand 中指定的
     * fallbackMethod方法获取返回值或执行异常处理。
     *
     * @param order
     */
    public Result defaultByPlaceOrder(Order order) {
        System.out.println("商品功能异常，请联系管理员~~~");
        return Result.fail(Result.FAIL_CODE, "商品功能异常，请联系管理员~~~");
    }


    /**
     * 熔断后该类的统一默认处理方法
     *
     * @DefaultProperties + @HystrixCommand 配合使用
     *
     * 必须要在方法上加上@HystrixCommand
     *
     * defaultFallback 定义的方法必须是无参的，并且与报错的方法的返回参数必须一致
     */
    public void defaultByOrderService() {
        System.out.println("商品服务系统异常！请联系管理员~~~");
    }
//    public Result defaultByOrderService() {
//        System.out.println("商品服务系统异常！");
//        return Result.fail(Result.FAIL_CODE, "商品服务系统异常！ 请联系管理员~~~");
//    }

    /**
     * 使用 Eureka + DiscoveryClient
     * @param order
     * @return
     */
//	private Result placeOrderByDiscoveryClient(Order order) {
//		// 获取商品服务地址列表
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
//
//	    return result;
//	}


}
