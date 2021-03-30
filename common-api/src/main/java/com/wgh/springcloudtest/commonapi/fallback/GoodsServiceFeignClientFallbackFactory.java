package com.wgh.springcloudtest.commonapi.fallback;

import com.wgh.springcloudtest.commonapi.client.GoodsServiceFeignClient;
import com.wgh.springcloudtest.commonapi.vo.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理
 *
 * Created by wgh on 2021/3/30.
 */
@Component
public class GoodsServiceFeignClientFallbackFactory implements FallbackFactory<GoodsServiceFeignClient> {
    @Override
    public GoodsServiceFeignClient create(Throwable throwable) {
        return new GoodsServiceFeignClient() {
            @Override
            public Result goodsInfo(String goodsId) {
                return Result.fail(500, "商品服务系统出现异常！！！ 请联系管理员！");
            }
        };
    }
}
