package com.oracle.udai.pay.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.oracle.udai.api.vo.OrderVO;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.pay.common.AliPay;
import com.oracle.udai.pay.common.WeiXinPay;
import com.oracle.udai.pay.service.PayService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PayServiceImpl
 * @Description: 支付的业务实现
 * @Author zhangxiaodong
 * @Date 2020/4/30 20:19
 * @Version V1.0
 */
@Service
public class PayServiceImpl implements PayService {


    /**
     * @param out_trade_no 订单号
     * @param payType      支付类型
     * @return 微信支付返回的是二维码url qrcode
     * 支付宝支付返回的是form表单页面
     * @description 根据支付类型完成支付
     */
    @Override
    public JsonBean payByType(String out_trade_no, String payType) {
        JsonBean jsonBean = new JsonBean(-1, "error", null);
        /*
         * 查询订单信息金额
         * 封装需要的数据到map
         */


        /*
         *此处需查询数据库
         */
        OrderVO orderVO = null;



        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", out_trade_no);//订单号
        map.put("body", "XXX购买");//订单描述
        if ("wxpay".equals(payType)) {
            map.put("total_fee", orderVO.getAmount().intValue() + "");//金额单位为分如999
            //微信扫码支付
            WeiXinPay weiXinPay = new WeiXinPay();
            try {
                String qrcode = weiXinPay.nativePay(map);//支付的微信二维码
                jsonBean = new JsonBean(0, "weixin", qrcode);//微信支付返回二维码url
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("alipay".equals(payType)) {
            //支付宝扫码支付
            map.put("total_amount", orderVO.getAmount().toString());//金额 单位为元如9.99
            AliPay aliPay = new AliPay();
            String form = "";
            try {
                form = aliPay.PCPagePay(JSON.toJSONString(map));//支付宝收银台的form表单
                jsonBean = new JsonBean(0, "alipay", form);
            } catch (AlipayApiException e) {
                e.printStackTrace();
            } finally {
                return jsonBean;
            }
        }
        return jsonBean;
    }

    /**
     * @param out_trade_no
     * @return
     * @description 查询订单是否已支付（调用第三方订单查询功能）
     */
    @Override
    public JsonBean queryOrderStatus(String out_trade_no) {
        return null;
    }

    /**
     * @param out_trade_no 订单号
     * @param skuId        商品skuid
     * @return
     * @description 退款
     */
    @Override
    public JsonBean refundOrder(String out_trade_no, Integer skuId) {
        return null;
    }
}
