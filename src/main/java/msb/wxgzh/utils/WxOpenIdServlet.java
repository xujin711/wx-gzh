//package msb.wxgzh.utils;
//
//import net.sf.json.JSONObject;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class WxOpenIdServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html");
//
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String code = request.getParameter("code");//获取code
//        Map params = new HashMap();
//        params.put("secret", "67b764519dbf910ac943d9ad7c77856f");
//        params.put("appid", "wxe32d77f767465935");
//        params.put("grant_type", "authorization_code");
//        params.put("code", code);
//        String result = HttpGetUtil.httpRequestToString(
//                "https://api.weixin.qq.com/sns/oauth2/access_token", params);
//        JSONObject jsonObject = JSONObject.fromObject(result);
//
//        String openid = jsonObject.get("openid").toString();
//        System.out.println("得到的openid为:"+openid);
//    }
//
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    }
