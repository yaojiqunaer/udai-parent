package com.oracle.udai.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.oracle.udai.pay.common.AlipayConfig.*;

/**
 * @ClassName AlipayController
 * @Description: 支付宝支付
 * @Author zhangxiaodong
 * @Date 2020/4/30 13:38
 * @Version V1.0
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * @param out_trade_no 订单号
     * @param payType      支付类型（微信 支付宝）
     * @return
     * @description
     */
    @PostMapping("pay")
    public JsonBean pay(String out_trade_no, String payType) {
        return payService.payByType(out_trade_no, payType);
    }

    /**
     * @param out_trade_no 订单号
     * @return
     * @description 支付宝支付
     */
    @RequestMapping("alipay")
    public JsonBean alipay(String out_trade_no) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
                ALIPAY_PUBLIC_KEY, SIGN_TYPE);  //获得初始化的AlipayClient
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("out_trade_no", out_trade_no);//订单号不可重复
        jsonObject.put("product_code", "FAST_INSTANT_TRADE_PAY");//目前仅支持FAST_INSTANT_TRADE_PAY
        jsonObject.put("total_amount", 99.99);//单价，单位元，小数点后两位
        jsonObject.put("subject", "沙箱支付宝测试");//订单标题
        //jsonObject.put("body", "");//订单描述,非必选
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        alipayRequest.setNotifyUrl("http://nav0six.hn3.mofasuidao.cn/pay/alipayNotify");//回调地址
        alipayRequest.setReturnUrl("http://nav0six.hn3.mofasuidao.cn/page/index.html");//成功跳转界面
        alipayRequest.setBizContent(jsonObject.toJSONString());//订单信息
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return new JsonBean(0, "Ok", form);//form为前端跳转的界面表单
    }

    @RequestMapping("alipayNotify")
    public String alipayNotify() {
        System.out.println("支付成功回调");
        return "success";
    }

}
