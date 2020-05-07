package com.oracle.udai.pay.common;

import com.github.wxpay.sdk.WXPay;

import java.util.Map;

/**
 * @ClassName WeiXinPay
 * @Description: 微信支付的封装
 * @Author zhangxiaodong
 * @Date 2020/4/30 20:33
 * @Version V1.0
 */
public class WeiXinPay {

    /**
     * @param map
     * @return 支付的二维码
     * @description 微信扫码支付
     */
    public String nativePay(Map<String, String> map) throws Exception {
        Map<String, String> resultMap = unifiedOrder(map);//下单返回结果
        if ("SUCCESS".equals(resultMap.get("return_code"))) {
            if ("SUCCESS".equals(resultMap.get("result_code"))) {
                return resultMap.get("code_url");//支付二维码
            }
        }
        return "";
    }

    /**
     * @param map
     * @return
     * @description 微信下单
     */
    public Map<String, String> unifiedOrder(Map<String, String> map) throws Exception {
        WXPay wxPay = new WXPay(new WeiXinpayConfig());
        //调用统一下单API返回结果
        Map<String, String> resultMap = wxPay.unifiedOrder(map);
        return resultMap;
    }

}
