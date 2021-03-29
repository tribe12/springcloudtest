package com.wgh.springcloudtest.userweb.controller;

import com.wgh.springcouldtest.commonapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wgh on 2021/3/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 没有使用 Eureka 时，uri 为消息提供者的地址，需要指定 ip 和 端口
     */
//	@RequestMapping("get/{id}")
//	public User get(@PathVariable("id") Integer id) throws Exception {
//		return restTemplate.getForObject(new URI("http://localhost:8081/provider/user/get/" + id), User.class);
//	}


    /**
     * 此处只是为了体现服务发现的效果，实际开发中不使用 DiscoveryClient 查询服务进行调用！
     * 至于如何进行服务发现和调用可以使用Ribbon
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * 使用 Eureka + DiscoveryClient
     * @param id
     * @return
     * @throws Exception
     */
//    @RequestMapping("get/{id}")
//    public User get(@PathVariable("id") Integer id) throws Exception {
//
//        List<ServiceInstance> list = this.client.getInstances("USER-API");
//        String uri = "";
//        for (ServiceInstance instance : list) {
//            if (instance.getUri() != null && !"".equals(instance.getUri())) {
//                uri = instance.getUri().toString();
//                System.out.println("uri:" + uri);
//                break;
//            }
//        }
//        return restTemplate.getForObject(uri + "/provider/user/get/" + id, User.class);
//    }


    /**
     *   使用 Eureka + Ribbon 后，uri 填写服务名称即可, 不必关心端口号
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("get/{id}")
    public User get(@PathVariable("id") Integer id) throws Exception {
        String url = "http://USER-API/provider/user/get/" + id;
        return restTemplate.getForObject(url, User.class);
    }

}