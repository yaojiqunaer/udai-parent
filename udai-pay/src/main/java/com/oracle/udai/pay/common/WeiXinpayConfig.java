package com.oracle.udai.pay.common;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * @ClassName WeXinpayConfig
 * @Description: 微信配置
 * @Author zhangxiaodong
 * @Date 2020/4/30 20:21
 * @Version V1.0
 */
public class WeiXinpayConfig implements WXPayConfig {


    @Override
    public String getAppID() {
        return null;
    }

    @Override
    public String getMchID() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
