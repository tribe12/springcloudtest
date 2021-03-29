package com.wgh.springcloudtest.orderserver.service;

import com.wgh.springcouldtest.commonapi.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wgh on 2021/3/29.
 */
@FeignClient(value="GOODS")
public interface GoodsFeignClientService {

    @RequestMapping("/goods/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable("goodsId") String goodsId);
}
