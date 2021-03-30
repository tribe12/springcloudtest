package com.wgh.springcloudtest.goodsserver02.service;


import com.wgh.springcloudtest.commonapi.model.Goods;

public interface GoodsService {

	Goods findGoodsById(String goodsId);
}
