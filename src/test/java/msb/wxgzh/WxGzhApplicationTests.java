package msb.wxgzh;

//import com.alibaba.fastjson.JSON;
import msb.wxgzh.pojo.HttpClientResult;
import msb.wxgzh.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxGzhApplicationTests {

    @Test
    public void contextLoads() {

    }


    /**
     * Description: 测试get无参请求
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/hello/get");
        System.out.println(result);
    }

    /**
     * Description: 测试get带参请求
     *
     * @throws Exception
     */
    @Test
    public void testGetWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "helloworld");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/hello/getWithParam", params);
        System.out.println(result);
    }

    /**
     * Description: 测试post带请求头不带请求参数
     *
     * @throws Exception
     */
    @Test
    public void testPost() throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "123");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8080/hello/post", headers, null);
        System.out.println(result);
    }

    /**
     * Description: 测试post带参请求
     * 测试该接口用例    http://127.0.0.1:8080/hello/postWithParam
     * @throws Exception
     */


	/*<xml>
   <appid>wx2421b1c4370ec43b</appid>
   <attach>支付测试</attach>
   <body>APP支付测试</body>
   <mch_id>10000100</mch_id>
   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
   <out_trade_no>1415659990</out_trade_no>
   <spbill_create_ip>14.23.150.211</spbill_create_ip>
   <total_fee>1</total_fee>
   <trade_type>APP</trade_type>
   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
</xml>*/
    @Test
    public void testPostWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("code", "0");
        params.put("message", "helloworld");

        params.put("appid", "wxe32d77f767465935");						//应用id  是string
        //params.put("attach", "helloworld");			//附加数据 否string
        params.put("body", "0");						//商品描述 是string
        params.put("mch_id", "1495306952");				//商户号  是string
        params.put("nonce_str", "0");					//随机字符串 是string
        params.put("out_trade_no", "helloworld");		//商户订单号 是string
        params.put("spbill_create_ip", "helloworld");	//终端IP  是string
        params.put("total_fee", "0");					//总金额 是int
        params.put("trade_type", "helloworld");			//交易类型 是string
        params.put("sign", "helloworld");//签名 是string
//        String s = JSON.toJSONString(params);
      //  System.out.println(s);





     //   HttpClientResult result = HttpClientUtils.doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", params);
        //System.out.println(result);
    }


}
