package com.wgh.springcloudtest.goodsserver03.service.impl;

import com.wgh.springcloudtest.goodsserver03.service.GoodsService;
import com.wgh.springcloudtest.commonapi.model.Goods;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class GoodsServiceImpl implements GoodsService{
	
	// 模拟数据库
	private static Map<String, Goods> data;
	
	static {
		data = new HashMap<>();
		data.put("1", new Goods("1", "手机", "国产手机", 8083));
		data.put("2", new Goods("2", "电脑", "台式电脑", 8083));
	}

	@Override
	public Goods findGoodsById(String goodsId) {
		return data.get(goodsId);
	}

}
