package com.wgh.springcloudtest.commonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单类
 * Created by wgh on 2021/3/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;

    private String goodsId;

    private int num;

}
