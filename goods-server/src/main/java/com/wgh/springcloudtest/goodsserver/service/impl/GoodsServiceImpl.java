package com.wgh.springcloudtest.goodsserver.service.impl;

import com.wgh.springcouldtest.commonapi.model.Goods;
import com.wgh.springcloudtest.goodsserver.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class GoodsServiceImpl implements GoodsService {
	
	// 模拟数据库
	private static Map<String, Goods> data;
	
	static {
		data = new HashMap<>();
		data.put("1", new Goods("1", "手机", "国产手机", 8081));
		data.put("2", new Goods("2", "电脑", "台式电脑", 8081));
	}

	@Override
	public Goods findGoodsById(String goodsId) {
		return data.get(goodsId);
	}

}
