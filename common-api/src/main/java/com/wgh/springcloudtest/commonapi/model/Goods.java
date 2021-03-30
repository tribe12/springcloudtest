package com.wgh.springcloudtest.commonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品类
 * Created by wgh on 2021/3/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {

    private String goodsId;

    private String name;

    private String descr;

    // 测试端口
    private int port;
}
