package com.wgh.springcloudtest.goodsserver.service;


import com.wgh.springcouldtest.commonapi.model.Goods;

public interface GoodsService {

	Goods findGoodsById(String goodsId);
}
