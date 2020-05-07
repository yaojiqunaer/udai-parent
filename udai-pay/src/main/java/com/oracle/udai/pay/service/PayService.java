package com.oracle.udai.pay.service;

import com.oracle.udai.common.JsonBean;

/**
 * @ClassName PayService
 * @Description: 支付业务层接口
 * @Author zhangxiaodong
 * @Date 2020/4/30 20:19
 * @Version V1.0
 */
public interface PayService {
    /**
     * @param out_trade_no 订单号
     * @param payType      支付类型
     * @return
     * @description 根据支付类型完成支付
     */
    JsonBean payByType(String out_trade_no, String payType);


    /**
     * @param out_trade_no 订单号
     * @return
     * @description 查询订单是否已支付（调用第三方订单查询功能）
     */
    JsonBean queryOrderStatus(String out_trade_no);

    /**
     * @param out_trade_no 订单号
     * @param skuId        商品skuid
     * @return
     * @description 退款
     */
    JsonBean refundOrder(String out_trade_no, Integer skuId);
}
