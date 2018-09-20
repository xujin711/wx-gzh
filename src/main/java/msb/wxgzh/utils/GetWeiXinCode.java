package msb.wxgzh.utils;


import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
     * 获取微信的code
     * @author
     * @修改日期 2018-9-10下午1:01:45
     */
    public class GetWeiXinCode {
        public static String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
        public static String getCodeRequest(){
            String result = null;
            GetCodeRequest  = GetCodeRequest.replace("APPID", urlEnodeUTF8("wxe32d77f767465935"));
            GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI",urlEnodeUTF8("http://juvenilenews.ccwqtv/pay"));
            GetCodeRequest = GetCodeRequest.replace("SCOPE", "snsapi_base");
            result = GetCodeRequest;
            return result;
//            Map<String,String> map = new HashMap<>();
//            map.put("appid","wxe32d77f767465935");
//            map.put("redirect_uri","http://juvenilenews.ccwqtv.com");
//            map.put("response_type","code");
//            map.put("scope","snsapi_base");
//            map.put("state","STATE#wechat_redirect");
//
//            String result = HttpGetUtil.httpRequestToString(
//                    "https://open.weixin.qq.com/connect/oauth2/authorize", map);
//            JSONObject jsonObject = JSONObject.fromObject(result);
//            String code = jsonObject.get("code").toString();
//            return code;
        }
        public static String urlEnodeUTF8(String str){
            String result = str;
            try {
                result = URLEncoder.encode(str,"UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }


//    public static String  GetAccessToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//    public static String  GetAccessToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    @ResponseBody
    public static String getGetAccessToken(HttpServletRequest request){
//        String code=getCodeRequest();
//        String result = null;
//        GetAccessToken  = GetAccessToken.replace("APPID", urlEnodeUTF8("wxe32d77f767465935"));
//        GetAccessToken  = GetAccessToken.replace("SECRET",urlEnodeUTF8("67b764519dbf910ac943d9ad7c77856f"));
        String code = request.getParameter("code");
//        result = GetAccessToken;

        Map<String,String> map = new HashMap<>();
        map.put("APPID","wxe32d77f767465935");
        map.put("SECRET","67b764519dbf910ac943d9ad7c77856f");
        map.put("CODE",code);
        map.put("grant_type","authorization_code");
        String result = HttpGetUtil.httpRequestToString(
                "https://api.weixin.qq.com/sns/oauth2/access_token", map);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String openid = "";
//        if(null!=jsonObject){
//            if(null!=jsonObject.get("openid")){
//                openid = jsonObject.get("openid").toString();
//            }
//
//        }
        return openid;
    }

    public static String getopenid() throws Exception{
        BufferedReader in = null;
//        //appid和secret是开发者分别是小程序ID和小程序密钥，开发者通过微信公众平台-》设置-》开发设置就可以直接获取，
//        String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxe32d77f767465935&secret=67b764519dbf910ac943d9ad7c77856f&js_code=snsapi_base&grant_type=authorization_code";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe32d77f767465935&redirect_uri=juvenilenews.ccwqtv.com&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        try {
            URL weChatUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = weChatUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
        // 使用finally块来关闭输入流
	        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(getCodeRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
