package com.oracle.udai.pay.common;

/**
 * @ClassName AlipayConfig
 * @Description: 支付宝支付所需参数配置（沙箱环境）
 * @Author zhangxiaodong
 * @Date 2020/4/30 13:31
 * @Version V1.0
 */
public class AlipayConfig {

    //支付宝网关,正式环境去掉dev
    public static String URL="https://openapi.alipaydev.com/gateway.do";
    //APPID 即创建应用后生成
    public static String APP_ID="2016101800713551";
    //开发者私钥，由开发者自己生成
    public static String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDaByPOdVo13kiENhaWFAAHYzjymA37oqN0H6FeaR3050gX/MgDt8H3GDgUvbsKjWBzCjTAwgGcOHPnSrF0h2IYvtGYHtXP67l8AFsw/IQQgwaw501HRocENJR8WqsTbh7IJVspG/h6eeGj1ByWtDhslGjIE3tPOBtV12UtHKLVOpbmQ0LA/bXAO2FRr3pPIjZuTclO6UYj+cOuWPbNLuqQkxZyrN5x3FERMjupAB6CA0yc/jB4SMJuxd1bcvJotBVNjdVP0p5tfUkjB2Tkb+NVtimk2PZAlcnd6Kj6wyzT45jUyefoL7m9zKqiN+JUnuu25jTJQRINRc7nvBGVB2RjAgMBAAECggEBAJxMngi17DPN5GKTe+Ge+N5S7VJMW0nXsCHhQwexh743x2Ea4DB6HV0MSbfkxB+udkRCPssoyYq6laxryYdmPpbKxOquwEzMCi6w+q7Fd892fud3Cdlc4BHNt9zmCtplCUAmN5Hi8WCr22xc9Rm8nO6J/gvgm3eRG1eQkIGkk78TbKST5qYXIAr24vf8CZIFSGDBlM+viPz6+OlY7xnuLgKtCTHxA3NUPkUMG2JRJ/ArQlXbrvZCNdCH/5wejvNMbz1KisqHVa2B6n5EkUDlsYLSHfIkoMFSQnman660MnQaXaGICHOBZtQXC4pkSV0L1m1fMiduQWq26uSe3h/e5bECgYEA8aABGEICNlToBVlKWIEi22kWYG/r7ZoUjf7fOPYHRnhU4rizK2tmQbds/zCawSvsRnF8QgEYiWfSO2c2dlO8UBOGeOo5H1988Cwvm+fP6FSSV+5Q64iXSUy8HqPgDhdkLw6yoop8xF7Dtz+XeDaUiS2q6a22gaHXVlBuIEDl9b8CgYEA5v+/LcPx4pl7zSOcNj+lWTjW6X2jRZ4GFsRE9gvqO3XZa4SQbhKzeKCPeZ2QvIVx+Wyh9KUa8ysUMchObXJrdVu3CzPW79pnDFzXJ9gXInv+JC+iq9Iv2TiqwzJkIfio8jQr22M0B7Q+16G0N5aCVDAfV9f7zzJQe4Of1eUWYl0CgYAhJB4iUqN1Ck5MtYOSAhxi1dYg4hkNHO4mz8eUS4KR8t1Jv6Wrle6PovYLRoJjbn/Y5aXyc64G4rueNDjvH+sbXKI8IXw2RmWfl5/sFW6Z4ke0Uda9h52giyreVQHdTO4L2ks8KhyU3p6fmtROw8W5zw67QH1g6G7dwuhn+h7QhwKBgCR/lkJx6l8mZyRDkyQTLFoLnBFqc4jFbircuhSyT0Ez3rWZTYTG2aqem+zYU40l/JsvaeuQxtBTJy6yeonagVYatrJDb5uYQ531cV1vTEB7nO00xZwmar8EsB6FcMLZWkBis+dHJmptNVy2xRXfZxpMPDeR/cyAI61QX8nZF49VAoGBAMMa9zzzUvADiDjEUr/kqCJi43bnOrQdB4vxsYPZmqezumJsGPUbpluLIECRPKqXM2kRX1xup5HQf+9pb9aLqZ7x2G9ivUOdAlxhZzEOIPpW1cyEAVys2WKeFuzx0EvY1Rt8tjtgFMBeayJjwaKBrsxMy9Q0ROG9Iw5Eo2PHVjC+";
    //参数返回格式，只支持 json
    public static String FORMAT="json";
    //编码集，支持 GBK/UTF-8
    public static String CHARSET="UTF-8";
    //支付宝公钥，由支付宝生成
    public static String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqM+HLqM3fbM3/CJ63XwGu9O/JeQbWxNquWdBr7fYEIHRmuRIfYEeur90FcvRj1EoSXWNZwIuI7ZwqCnKsAe0WNptsV66872RlVuPuaIWTVFDmrSfF1gZzMjWLufP+Wc1nopkXja6cVFZy3M3xo1XObmSqh6m6FLZ8I6Ur71/RpeZdMux0gD/Q8EpB/JwhCYchToCGtTk773W/hKLVXUo5z2vHk8fDKMLgrgOC3oWSfNx5Likn41Zi5TsAV3mrMMjD2Xib2GWy363no77U10AElHshpOLO/OApoxIEG8F4x88RhNZDq7UwRHjrAG+RZ6qQMdCtXBH+j1wwJDL3gtxdwIDAQAB+HLqM3fbM3/CJ63XwGu9O/JeQbWxNquWdBr7fYEIHRmuRIfYEeur90FcvRj1EoSXWNZwIuI7ZwqCnKsAe0WNptsV66872RlVuPuaIWTVFDmrSfF1gZzMjWLufP+Wc1nopkXja6cVFZy3M3xo1XObmSqh6m6FLZ8I6Ur71/RpeZdMux0gD/Q8EpB/JwhCYchToCGtTk773W/hKLVXUo5z2vHk8fDKMLgrgOC3oWSfNx5Likn41Zi5TsAV3mrMMjD2Xib2GWy363no77U10AElHshpOLO/OApoxIEG8F4x88RhNZDq7UwRHjrAG+RZ6qQMdCtXBH+j1wwJDL3gtxdwIDAQAB";
    //加签类型
    public static String SIGN_TYPE="RSA2";
    //回调地址
    public static String NOTIFYURL="http://nav0six.hn3.mofasuidao.cn/pay/alipayNotify";
    //跳转地址
    public static String RETURNURL="http://nav0six.hn3.mofasuidao.cn/page/success.html";
}
