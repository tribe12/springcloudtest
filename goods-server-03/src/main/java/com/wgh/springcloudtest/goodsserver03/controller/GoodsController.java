package com.wgh.springcloudtest.goodsserver03.controller;

import com.wgh.springcloudtest.goodsserver03.service.GoodsService;
import com.wgh.springcloudtest.commonapi.model.Goods;
import com.wgh.springcloudtest.commonapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
