package com.wgh.springcloudtest.goodsserver.controller;

import com.wgh.springcloudtest.goodsserver.service.GoodsService;
import com.wgh.springcouldtest.commonapi.model.Goods;
import com.wgh.springcouldtest.commonapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgh on 2021/3/27.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable String goodsId) {

        Goods goods = this.goodsService.findGoodsById(goodsId);
        return Result.success(goods);
    }
}
