package msb.wxgzh.constants;

import org.apache.http.client.HttpClient;

public class WeixinConstants {

    public enum SignType {
        MD5, HMACSHA256
    }

    /**
     * 配置
     */
//    //码上播
//   //公众账号ID
//    public static final String APPID = "wxe32d77f767465935";
//    //商户号
//    public static final String MCHID = "1495306952";
//    //API密钥
//    public static final String APIKEY="mashangbo2018mashangbo2018qwerty";
//    //appSecret
//    public static final String APPSECRET = "67b764519dbf910ac943d9ad7c77856f";
    //现在

    //公众账号ID
    public static final String APPID = "wx442887ad4fe5762d";
    //商户号
    public static final String MCHID = "1508280571";
    //API密钥
    public static final String APIKEY="mashangbo2018mashangbo2018qwerty";
    //appSecret
    public static final String APPSECRET = "9565454a5515889da47d2be89c72b019";



    /**
     * URL
     */
    //统一下单
    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //查询订单
    public static final String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

    //异步通知充值结果地址
    public static final String RETURNPAYURL="http://mwm.aixinmakeji.com/resultPay";

    //授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
    public static final String REDIRECT_URI="http://mwm.aixinmakeji.com/getUserInfo";


    //企业获取code
//    public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
    //https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&agentid=AGENTID&state=STATE#wechat_redirect


    public static final String WXPAYSDK_VERSION = "WXPaySDK/3.0.9";
    public static final String USER_AGENT = WXPAYSDK_VERSION +
            " (" + System.getProperty("os.arch") + " " + System.getProperty("os.name") + " " + System.getProperty("os.version") +
            ") Java/" + System.getProperty("java.version") + " HttpClient/" + HttpClient.class.getPackage().getImplementationVersion();
    /**
     * 常量
     */

    //商品描述
    public static final String BODY = "充值";
    //
    public static final String SCOPE="snsapi_base";

    //签名
    public static final String FIELD_SIGN = "sign";
    //交易类型
    //JSAPI 公众号支付
    //NATIVE 扫码支付
    //APP APP支付
    //说明详见参数规定
    public static final String JSAPI = "JSAPI";
    public static final String NATIVE = "NATIVE";
    public static final String APP = "APP";

    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 6*1000;
    public static final int DEFAULT_READ_TIMEOUT_MS = 8*1000;

    public static final String RETURNERROR="ERROR";

    public static final String RETURNSUCCESS="SUCCESS";

    /**
     * 测试账号的相关配置
     */
//    //公众账号ID
//    public static final String APPID = "wx82c9108fa81337e6";
//    //统一下单
//    public static final String APPSECRET = "6fa9ebd602db9680d64013fd890ab10c";
}
