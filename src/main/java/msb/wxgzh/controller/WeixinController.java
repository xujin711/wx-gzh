package msb.wxgzh.controller;

import lombok.extern.slf4j.Slf4j;
import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.enums.ResultEnum;
import msb.wxgzh.exception.SellException;
import msb.wxgzh.pojo.Personal;
import msb.wxgzh.service.WeixinService;
import msb.wxgzh.vo.OrderqueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by
 *
 */
//@Controller
//@RequestMapping("/weixin")
@RestController
@Slf4j
public class WeixinController {

    @Autowired
    private WeixinService weixinService;
//    @Autowired
//    private
//    @GetMapping("/authorize")
//    public void authorize() {
//        log.info("进入authorize方法。。。");
////        log.info("code={}", code);
//
//        String redirect_uri="http://trfh.shopbest.com.cn/weixin/auth/";
//        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=" + redirect_uri + "&appid=wxe32d77f767465935&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response={}", response);
//        //这里要将你的授权回调地址处理一下，否则微信识别不了
////        String redirect_uri = URLEncoder.encode("juvenilenews.ccwqtv.com", "UTF-8");
////        //简单获取openid的话参数response_type与scope与state参数固定写死即可
////        StringBuffer url = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=" + redirect_uri +
////                "&appid=wxe32d77f767465935&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
////
//////        https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&agentid=AGENTID&state=STATE#wechat_redirect
////        response.sendRedirect(url.toString());//这里请不要使用get请求单纯的将页面跳转到该url即可
//    }

//    /**
//     * 通过code获取open_id
//     * @param code
//     */
//    @GetMapping("/auth")
//    public void auth(@RequestParam("code") String code) {
//        log.info("进入auth方法。。。");
//        log.info("code={}", code);
//
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd898fcb01713c658&secret=29d8a650db31472aa87800e3b0d739f2&code=" + code + "&grant_type=authorization_code";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response={}", response);
//    }

    /**
     * 订单接口
     * @param
     * @return
     */
    @RequestMapping(value ="/getToken/{token}",method = RequestMethod.GET)
    public ResultResponse<Void> selectOrder(@PathVariable(value = "token") String token){
        ResultResponse<Void> response = new ResultResponse<>();

        String str = token;
        System.out.println(str);
        response.setMessage("查询用户信息失败");
        response.setStatusCode(500);
        return response;

    }

    /**
     * 通过code获取open_id,进而获取用户信息http%3a%2f%2fhappy123.free.idcfengye.com%2fgetUserInfo
     * https://weixinmeifangui.free.idcfengye.com
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx82c9108fa81337e6&redirect_uri=https%3a%2f%2fweixinmeifangui.free.idcfengye.com%2fgetUserInfo&response_type=code&scope=snsapi_login&state=123#wechat_redirect
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx82c9108fa81337e6&redirect_uri=https://weixinmeifangui.free.idcfengye.com/getUserInfo&response_type=code&scope=snsapi_base&state=123#wechat_redirect
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe32d77f767465935&redirect_uri=http://juvenilenews.ccwqtv.com/getUserInfo&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe32d77f767465935&redirect_uri=http%3a%2f%2fjuvenilenews.ccwqtv.com%2fgetUserInfo&response_type=code&scope=snsapi_base&state=123#wechat_redirect
     * @return
     *
     * 	@GetMapping(value= "/getMessagePath")
     * 	public Response getResponse(@RequestParam(value="message") String message)  {
     * 		return responseServiceImpl.getResponse(message);
     *
     */
    @RequestMapping(value ="/getUserInfo",method = RequestMethod.GET)
    public ResultResponse<List<Personal>> getUserInfo(@RequestParam(value="code") String code){
//        log.info("code={}", code);
        ResultResponse<List<Personal>> response = new ResultResponse<>();
        Personal personal = new Personal();
        personal.setCode(code);
//        personal.setUserId(userId);
        try{
            List<Personal> list = weixinService.getUserInfo(personal);
            if(list !=null && list.size()>0){
                response.setMessage("查询用户信息成功");
                response.setStatusCode(200);
                response.setResult(list);
            }else {
                response.setMessage("查询用户信息失败");
                response.setStatusCode(500);
            }
        }catch (Exception e){
            log.info("通过code获取open_id,进而获取用户信息异常");
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
//    @PostMapping("/resultPay")
    @ResponseBody
    @RequestMapping(value ="/resultPay",method = RequestMethod.POST)
    public ModelAndView notify(@RequestBody String notifyData) {
        try {
            Integer num=weixinService.notify(notifyData);
            if(num>0){
                return new ModelAndView("pay/success");
            }else{
                log.error("【微信支付】异步通知, 修改数据失败");
                throw new SellException(ResultEnum.UPDATEFAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回给微信处理结果
        return null;
    }


    /**
     * 微信订单查询接口
     * @param outTradeNo
     */
    @RequestMapping(value ="/orderquery/{outTradeNo}",method = RequestMethod.GET)
    public ResultResponse<List<OrderqueryVO>> orderquery(@PathVariable(value = "outTradeNo") String outTradeNo){
        ResultResponse<List<OrderqueryVO>> response = new ResultResponse<>();

        List<OrderqueryVO> list = null;
        try {
            list = weixinService.orderqueryByOutTradeNo(outTradeNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list !=null && list.size()>0){
            response.setMessage("微信订单查询成功");
            response.setStatusCode(200);
            response.setResult(list);
        }else {
            response.setMessage("微信订单查询失败");
            response.setStatusCode(500);
        }
        return response;

    }

//    /**
//     * 微信支付结果异步通知
//     * @return
//     */
//    @RequestMapping(value ="/resultPay",method = RequestMethod.POST)
//    public ResultResponse<List<Personal>> resultPay(Personal personal){
////        log.info("code={}", code);
//        ResultResponse<List<Personal>> response = new ResultResponse<>();
//        try{
//            List<Personal> list = weixinService.getUserInfo(personal);
//            if(list !=null && list.size()>0){
//                response.setMessage("查询用户信息成功");
//                response.setStatusCode(200);
//                response.setResult(list);
//            }else {
//                response.setMessage("查询用户信息失败");
//                response.setStatusCode(500);
//            }
//        }catch (Exception e){
//            log.info("通过code获取open_id,进而获取用户信息异常");
//            e.printStackTrace();
//        }
//
//        return response;
//
//
//    }
}
