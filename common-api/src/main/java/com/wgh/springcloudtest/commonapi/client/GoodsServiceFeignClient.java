package com.wgh.springcloudtest.commonapi.client;

import com.wgh.springcloudtest.commonapi.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wgh on 2021/3/30.
 */
@FeignClient(value = "GOODS")
public interface GoodsServiceFeignClient {
    @RequestMapping("/goods/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable("goodsId") String goodsId);
}
