package com.oracle.udai.pay.common;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import static com.oracle.udai.pay.common.AlipayConfig.*;

/**
 * @ClassName AliPay
 * @Description: 支付宝支付封装
 * @Author zhangxiaodong
 * @Date 2020/4/30 21:35
 * @Version V1.0
 */
public class AliPay {
    private AlipayClient alipayClient = null;

    public AliPay() {
        this.alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
                ALIPAY_PUBLIC_KEY, SIGN_TYPE);  //获得初始化的AlipayClient
    }

    /**
     * @param json 订单信息的json数据()
     * @return form表单字符串
     * @description pc场景下单并支付
     */
    public String PCPagePay(String json) throws AlipayApiException {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        alipayRequest.setNotifyUrl(NOTIFYURL);//回调地址
        alipayRequest.setReturnUrl(RETURNURL);//成功跳转界面
        alipayRequest.setBizContent(json);//订单信息
        return alipayClient.pageExecute(alipayRequest).getBody();
    }
}
