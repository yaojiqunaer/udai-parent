package com.oracle.udai.order.service;

import com.alibaba.fastjson.JSONObject;
import com.oracle.udai.common.JsonBean;

/**
 * @ClassName OrderService
 * @Description: 订单业务接口
 * @Author zhangxiaodong
 * @Date 2020/5/3 13:43
 * @Version V1.0
 */
public interface OrderService {


    /**
     * @param json json数据
     *                   {
     *                   "skuArray":[
     *                   {
     *                   "skuId":1,
     *                   "skuCount":2
     *                   },
     *                   {
     *                   "skuId":2,
     *                   "skuCount":1
     *                   }
     *                   ],
     *                   "voucherId":null
     *                   }
     * @return
     * @description 创建订单
     */
    JsonBean createOrder(JSONObject json);
}
