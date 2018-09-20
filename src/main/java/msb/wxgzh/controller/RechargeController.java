package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.Recharge;
import msb.wxgzh.service.RechargeService;
import msb.wxgzh.service.WeixinService;
import msb.wxgzh.vo.WeixinUnifiedReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RechargeController {


    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private WeixinService weixinService;

//    /**
//     * 生成预订单,获取code
//     * @return
//     */
//    @RequestMapping(value ="/getCode",method = RequestMethod.POST)
//    public ResultResponse<List<WeixinUnifiedReturnVO>> getCode(WeixinUnifiedOrderVO weixinUnifiedOrderVO){
//
////        GetWeiXinCode.getCodeRequest();
//
//        ResultResponse<List<WeixinUnifiedReturnVO>> response = new ResultResponse<>();
//        WeixinUnifiedReturnVO weixinUnifiedReturnVO = new WeixinUnifiedReturnVO();
//        List<WeixinUnifiedReturnVO> list = new ArrayList<>();
//        if(null!=weixinUnifiedOrderVO){
//            response.setMessage("充值失败，请检查参数");
//            response.setStatusCode(500);
//            return response;
//        }
//
//        //调用统一下单接口获取预支付id
//        try {
//
//            weixinService.getOpenid(weixinUnifiedOrderVO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        Integer num = rechargeService.insertRecharge(recharge);
//        if(null!=weixinUnifiedReturnVO){
//            String return_code=weixinUnifiedReturnVO.getReturn_code();
//            if("SUCCESS".equals(return_code)){
//                response.setMessage("充值预支付成功");
//                response.setStatusCode(200);
//                list.add(weixinUnifiedReturnVO);
//                response.setResult(list);
//            }else {
//                response.setMessage("充值预支付失败");
//                response.setStatusCode(500);
//                list.add(weixinUnifiedReturnVO);
//                response.setResult(list);
//            }
//
//        }else {
//            response.setMessage("充值失败，请检查网络");
//            response.setStatusCode(500);
//        }
//        return response;
//    }

//    /**
//     * 充值接口
//     * @return
//     */
//    @RequestMapping(value ="/pay",method = RequestMethod.POST)
//    public ResultResponse<List<WeixinUnifiedReturnVO>> pay(WeixinUnifiedOrderVO weixinUnifiedOrderVO, HttpServletRequest request){
//        ResultResponse<List<WeixinUnifiedReturnVO>> response = new ResultResponse<>();
//        List<WeixinUnifiedReturnVO> list = new ArrayList<>();
//        //调用统一下单接口获取预支付id
//        try {
//
//            list = weixinService.getUnifiedOrder(weixinUnifiedOrderVO,request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        Integer num = rechargeService.insertRecharge(recharge);
//        if(list !=null && list.size()>0){
//            response.setMessage("充值成功");
//            response.setStatusCode(200);
//            response.setResult(list);
//        }else {
//            response.setMessage("充值失败，请检查网络");
//            response.setStatusCode(500);
//        }
//            return response;
//    }

    /**
     * 充值接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/submitRecharge",method = RequestMethod.POST)
    public ResultResponse<List<WeixinUnifiedReturnVO>> submitRecharge(@RequestBody Recharge recharge){

//        GetWeiXinCode.getCodeRequest();

        ResultResponse<List<WeixinUnifiedReturnVO>> response = new ResultResponse<>();
        WeixinUnifiedReturnVO weixinUnifiedReturnVO = new WeixinUnifiedReturnVO();
        List<WeixinUnifiedReturnVO> list = new ArrayList<>();
        if(null==recharge){
            response.setMessage("充值失败，请检查参数");
            response.setStatusCode(500);
            return response;
        }

        //调用统一下单接口获取预支付id
        try {

            weixinUnifiedReturnVO = weixinService.getUnifiedOrder(recharge);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Integer num = rechargeService.insertRecharge(recharge);
        if(null!=weixinUnifiedReturnVO){
            String return_code=weixinUnifiedReturnVO.getReturn_code();
            if("SUCCESS".equals(return_code)){
                response.setMessage("充值预支付成功");
                response.setStatusCode(200);
                list.add(weixinUnifiedReturnVO);
                response.setResult(list);
            }else {
                response.setMessage("充值预支付失败");
                response.setStatusCode(500);
                list.add(weixinUnifiedReturnVO);
                response.setResult(list);
            }

        }else {
            response.setMessage("充值失败，请检查网络");
            response.setStatusCode(500);
        }
        return response;
    }


}
