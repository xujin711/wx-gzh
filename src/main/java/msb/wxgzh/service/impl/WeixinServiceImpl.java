package msb.wxgzh.service.impl;

import lombok.extern.slf4j.Slf4j;
import msb.wxgzh.constants.WeixinConstants;
import msb.wxgzh.enums.ResultEnum;
import msb.wxgzh.exception.SellException;
import msb.wxgzh.mapper.PersonalMapper;
import msb.wxgzh.mapper.RechargeMapper;
import msb.wxgzh.pojo.Personal;
import msb.wxgzh.pojo.Recharge;
import msb.wxgzh.service.OrderService;
import msb.wxgzh.service.WeixinService;
import msb.wxgzh.utils.*;
import msb.wxgzh.vo.OrderqueryVO;
import msb.wxgzh.vo.WeixinUnifiedReturnVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.*;

import static msb.wxgzh.utils.WeixinUtil.getV4IP;


@Service
@Slf4j
public class WeixinServiceImpl implements WeixinService {

    @Autowired
    private PersonalMapper personalMapper;

    @Autowired
    private RechargeMapper rechargeMapper;

//    @Autowired
//    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;


//    /**
//     * 获取code
//     * @param weixinUnifiedOrderVO
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public void getOpenid(WeixinUnifiedOrderVO weixinUnifiedOrderVO) throws Exception {
//
////        List<WeixinUnifiedReturnVO> returnList = new ArrayList<>();
//        WeixinUnifiedReturnVO weixinUnifiedReturnVO = new WeixinUnifiedReturnVO();
//        //获取参数
//        //生成订单号
//        String rechargeOrdernum= IdGenerator.getId();
//        //1生成用户订单,存入数据库
//        Recharge recharge = new Recharge();
//        recharge.setUserId(weixinUnifiedOrderVO.getUserId());
//        recharge.setUserName(weixinUnifiedOrderVO.getUserName());
//        recharge.setAmount(weixinUnifiedOrderVO.getAmount());
//        recharge.setBalanceAmount(weixinUnifiedOrderVO.getBalanceAmount());
//        recharge.setCreateTime(weixinUnifiedOrderVO.getCreateTime());
//        recharge.setStatus(weixinUnifiedOrderVO.getStatus());
//        recharge.setUpdateId(weixinUnifiedOrderVO.getUpdateId());
//        recharge.setUpdateName(weixinUnifiedOrderVO.getUpdateName());
//        recharge.setUpdateTime(weixinUnifiedOrderVO.getUpdateTime());
//        recharge.setIsDel(weixinUnifiedOrderVO.getIsDel());
//        recharge.setRechargeOrdernum(rechargeOrdernum);
//        recharge.setTotalFee(weixinUnifiedOrderVO.getTotal_fee());
//        recharge.setSpbillCreateIp(weixinUnifiedOrderVO.getSpbill_create_ip());
//
//        Integer num = rechargeMapper.insert(recharge);
//        if(num == 1) {
//            //用户同意授权，获取code
////            https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
//            getCodeRequest();
//        }
//    }
//    public static String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
//    public static String getCodeRequest(){
//        String result = null;
//        GetCodeRequest  = GetCodeRequest.replace("APPID", urlEnodeUTF8(WeixinConstants.APPID));
//        GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI",urlEnodeUTF8(WeixinConstants.REDIRECT_URI));
//        GetCodeRequest = GetCodeRequest.replace("SCOPE", WeixinConstants.SCOPE);
//        result = GetCodeRequest;
//        return result;
//    }
//    public static String urlEnodeUTF8(String str){
//        String result = str;
//        try {
//            result = URLEncoder.encode(str,"UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


    @Override
    @Transactional
    public WeixinUnifiedReturnVO getUnifiedOrder(Recharge weixinUnifiedOrderVO) throws Exception {

//        List<WeixinUnifiedReturnVO> returnList = new ArrayList<>();
        WeixinUnifiedReturnVO weixinUnifiedReturnVO = new WeixinUnifiedReturnVO();
        //获取参数
        //生成订单号
        String rechargeOrdernum= IdGenerator.getId();
        //1生成用户订单,存入数据库
        Recharge recharge = new Recharge();
        recharge.setUserId(weixinUnifiedOrderVO.getUserId());
        recharge.setUserName(weixinUnifiedOrderVO.getUserName());
        recharge.setAmount(weixinUnifiedOrderVO.getAmount());
        recharge.setBalanceAmount(weixinUnifiedOrderVO.getBalanceAmount());
        recharge.setCreateTime(weixinUnifiedOrderVO.getCreateTime());
        recharge.setStatus(weixinUnifiedOrderVO.getStatus());
        recharge.setUpdateId(weixinUnifiedOrderVO.getUpdateId());
        recharge.setUpdateName(weixinUnifiedOrderVO.getUpdateName());
        recharge.setUpdateTime(weixinUnifiedOrderVO.getUpdateTime());
        recharge.setIsDel(weixinUnifiedOrderVO.getIsDel());
        recharge.setRechargeOrdernum(rechargeOrdernum);
        recharge.setTotalFee(weixinUnifiedOrderVO.getTotalFee());
        recharge.setSpbillCreateIp(weixinUnifiedOrderVO.getSpbillCreateIp());

        Integer num = rechargeMapper.insert(recharge);
        if(num == 1){


            //参数转换为Map
            Map<String,String> map=paramsToMap(weixinUnifiedOrderVO,rechargeOrdernum);

            //将Map转换为XML格式的字符串
            String str = WeixinUtil.mapToXml(map);
            //调用统一下单接口,得到prepay_id
            String returnXMLStr=WeixinUtil.httpRequest(str,WeixinConstants.DEFAULT_CONNECT_TIMEOUT_MS,WeixinConstants.DEFAULT_READ_TIMEOUT_MS,WeixinConstants.UNIFIEDORDER_URL);
            //XML格式字符串转换为Map
            Map<String, String> xmlToMap = WeixinUtil.xmlToMap(returnXMLStr);
            //在return_code为SUCCESS的时候有返回result_code
    //        String return_code=xmlToMap.get("return_code");
    //        if(null!=return_code && "SUCCESS".equals(return_code)){
    //            String result_code=map.get("result_code");
    //            if(null!=result_code && "SUCCESS".equals(result_code)){
    //                //得到prepay_id 预支付交易会话标识
    //                String prepay_id=map.get("prepay_id");
    //            }
    //        }

            weixinUnifiedReturnVO.setReturn_code(xmlToMap.get("return_code"));
            weixinUnifiedReturnVO.setReturn_msg(xmlToMap.get("return_msg"));
            weixinUnifiedReturnVO.setAppid(xmlToMap.get("appid"));
            weixinUnifiedReturnVO.setMch_id(xmlToMap.get("mch_id"));
            weixinUnifiedReturnVO.setDevice_info(xmlToMap.get("device_info"));
            weixinUnifiedReturnVO.setNonce_str(xmlToMap.get("nonce_str"));
            weixinUnifiedReturnVO.setSign(xmlToMap.get("sign"));
            weixinUnifiedReturnVO.setResult_code(xmlToMap.get("result_code"));
            weixinUnifiedReturnVO.setErr_code(xmlToMap.get("err_code"));
            weixinUnifiedReturnVO.setErr_code_des(xmlToMap.get("err_code_des"));
            weixinUnifiedReturnVO.setTrade_type(xmlToMap.get("trade_type"));
            weixinUnifiedReturnVO.setPrepay_id(xmlToMap.get("prepay_id"));
            weixinUnifiedReturnVO.setCode_url(xmlToMap.get("code_url"));
            weixinUnifiedReturnVO.setOut_trade_no(rechargeOrdernum);
//            returnList.add(weixinUnifiedReturnVO);
            return weixinUnifiedReturnVO;
        }else{
            return weixinUnifiedReturnVO;
        }
    }

    //参数转换为Map
    public Map<String,String> paramsToMap(Recharge weixinUnifiedOrderVO, String rechargeOrdernum) throws Exception {
        //参数转换为Map
        Map<String,String> map = new HashMap<>();
        //公众账号ID(必填)
        map.put("appid", WeixinConstants.APPID);
        //商户号(必填)
        map.put("mch_id", WeixinConstants.MCHID);
        //随机字符串(必填)
        map.put("nonce_str", WeixinUtil.generateNonceStr());

        //商品描述(必填)//随意填写,前端传值
        map.put("body", WeixinConstants.BODY);

        //商户订单号(必填)
        /**
         * 商户支付的订单号由商户自定义生成，仅支持使用字母、数字、中划线-、下划线_、竖线|、星号*这些英文半角字符的组合，
         * 请勿使用汉字或全角等特殊字符。微信支付要求商户订单号保持唯一性（建议根据当前系统时间加随机序列来生成订单号）。
         * 重新发起一笔支付要使用原订单号，避免重复支付；已支付过或已调用关单、撤销（请见后文的API列表）的订单号不能重新发起支付。
         */
        map.put("out_trade_no", rechargeOrdernum);
        //标价金额(必填)订单总金额，单位为分，详见支付金额
        int totalFee=weixinUnifiedOrderVO.getTotalFee();
        String total_fee=String.valueOf(totalFee);
        map.put("total_fee", total_fee);//随意填写,前端传值

        String ip = InetAddress.getLocalHost().getHostAddress();
        map.put("spbill_create_ip", ip);
//        map.put("spbill_create_ip", getV4IP());//随意填写,前端传值
        //终端IP(必填)APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
//        map.put("spbill_create_ip", weixinUnifiedOrderVO.getSpbillCreateIp());//随意填写,前端传值

        //通知地址(必填)异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        map.put("notify_url", WeixinConstants.RETURNPAYURL);//随意填写,应该为生产地址

        //交易类型(必填)
        //JSAPI 公众号支付
        //NATIVE 扫码支付
        //APP APP支付
        //说明详见参数规定
        map.put("trade_type", WeixinConstants.JSAPI);

        //openid
        //1企业获取code
//        WxCodeServlet.doPost();
//        String returnXMLStr=WeixinUtil.httpRequest(str,WeixinConstants.DEFAULT_CONNECT_TIMEOUT_MS,WeixinConstants.DEFAULT_READ_TIMEOUT_MS,WeixinConstants.AUTHORIZE_URL);
//        GetWeiXinCode.getCodeRequest();
////        String openid="oUpF8uMuAJO_M2pxb1Q9zNjWeS6o";
//        String openid=GetWeiXinCode.getGetAccessToken(request);
        //用户标识 (非必填)trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
        map.put("openid", weixinUnifiedOrderVO.getOpenid());

        //签名(必填)
        //签名要放到最后
        String sign=WeixinUtil.generateSignature(map,WeixinConstants.APIKEY);
        map.put("sign", sign);

//        //设备号(非必填)	自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
//        private String device_info;
//        //签名类型(非必填)签名类型，默认为MD5，支持HMAC-SHA256和MD5。
//        private String sign_type;
//        //商品详情(非必填)商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
//        private String detail;
//        //附加数据(非必填)附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
//        private String attach;
//        //标价币种(非必填)符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
//        private String fee_type;
//        //交易起始时间(非必填)订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
//        private String time_start;
//        //交易结束时间(非必填)订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则
//        //建议：最短失效时间间隔大于1分钟
//        private String time_expire;
//        //订单优惠标记(非必填)订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠
//        private String goods_tag;
//        //商品ID(非必填)trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
//        private String product_id;
//        //指定支付方式 (非必填)上传此参数no_credit--可限制用户不能使用信用卡支付
//        private String limit_pay;

//        //场景信息(非必填)该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
//        private List<WeixinSceneInfoVO> scene_info;
        return map;
    }



    /**
     * 通过code,获取openid
     * 拉取用户信息
     * @param personal
     * @return
     * @throws Exception
     */
    @Override
    public List<Personal> getUserInfo(Personal personal) throws Exception{
        Personal personalInfo = new Personal();
        List<Personal> list = new ArrayList<>();
        //通过code,获取tokenid,
        String code=personal.getCode();
        log.info("code={}", code);

        //通过code,获取tokenid,
        String accessToken=getAccessToken(code);
        //拉取用户信息
        String snsapi_userinfo=getUserInfoByToken(accessToken);

//        if("拉取用户信息".equals(snsapi_userinfo)){
//            list.add(personalInfo);
//        }
//        JSONObject jsonObject=JSONObject.fromObject(snsapi_userinfo);
//        Personal weixinAccessToken=(Personal)JSONObject.toBean(jsonObject, Personal.class);
//        String unionid=weixinAccessToken.getUnionid();

        Map<String, Object> map = paramToMap(snsapi_userinfo);
        if(null!=map && null!=map.get("openid")){
            String openid = map.get("openid").toString();
            //根据openid查询数据库,如果没查到,则插入,并且返回微信查询到的信息,如果在数据库中查询到信息,则不坐数据库更新,并且把查到测信息返回给前端

            Personal personalInfos = personalMapper.selectByUnionid(openid);
            if(null!=personalInfos){
                list.add(personalInfos);
            }else{
                Personal weixinAccessToken = new Personal();
                weixinAccessToken=MapToBeanUtil.map2Bean(weixinAccessToken,map);
                int num = personalMapper.insert(weixinAccessToken);
                if(num<1){
                    log.error("【微信授权】插入数据失败");
                    throw new SellException(ResultEnum.INSERTFAIL);
                }
                list.add(weixinAccessToken);
            }
            return list;
        }else{
            log.error("【微信授权】返回参数无openid");
            throw new SellException(ResultEnum.NOOPTIONID);
        }
    }


    /**
     * 通过code,获取tokenid,
     * @param code
     * @return
     */
    public String getAccessToken(String code){
        String appid=WeixinConstants.APPID;
        String secret = WeixinConstants.APPSECRET;

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";


        /**
         * 乱码
         */
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        RestTemplate restTemplate = new RestTemplateBuilder().additionalMessageConverters(m).build();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

//        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        return response;
    }
    /**
     * 拉取用户信息
     * @param accessToken
     * @return
     */
    public String getUserInfoByToken(String accessToken) throws Exception{


//        Map map1 = JSON.parseObject(accessToken);
        Map<String, Object> map = paramToMap(accessToken);

        Long errcode = (Long) map.get("errcode");

        if(null!=errcode){
//            String str = WeixinConstants.RETURNERROR;
            log.error("【微信授权】通过code换取网页授权access_token错误, errcode={}", errcode);
            throw new SellException(ResultEnum.NOSUCCESS);
//            return str;
        }else{
//            JSONObject jsonObject=JSONObject.fromObject(accessToken);
//            WeixinAccessTokenVO weixinAccessToken=(WeixinAccessTokenVO)JSONObject.toBean(jsonObject, WeixinAccessTokenVO.class);

            String reaccessToken= map.get("access_token").toString();
            String reopenId=map.get("openid").toString();
//            weixinAccessToken.getAccess_token();
//            String reopenId=weixinAccessToken.getOpenid();

            String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+reaccessToken+"&openid="+reopenId+"&lang=zh_CN";

            /**
             * 乱码
             */
            StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            RestTemplate restTemplate = new RestTemplateBuilder().additionalMessageConverters(m).build();
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

//        RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class,"UTF-8");
            log.info("response={}", response);
            Map<String, Object> map2 = paramToMap(response);
//            Long errcode2 = Long.parseLong(map2.get("errcode").toString());
            Long errcode2 = (Long) map2.get("errcode");
            if(null!=errcode2){
//                String str = WeixinConstants.RETURNERROR;
                log.error("【微信授权】拉取用户信息错误, errcode={}", errcode);
                throw new SellException(ResultEnum.NOSUCCESS);
//            return str;
            }
            return response;
        }


    }


//    public static void main(String args[]){
//        Map<String,String> map = new HashMap<>();
//        String errcode = (String) map.get("errcode");
//        System.out.println(errcode);
//    }
    @Override
    @Transactional
    public Integer notify(String notifyData) throws Exception{
        //1. 验证签名
        //2. 支付的状态
        //3. 支付金额
        //4. 支付人(下单人 == 支付人)
        //签名验证,并校验返回的订单金额是否与商户侧的订单金额一致

        Map<String,String> map = new HashMap<String, String>();
        Integer num=0;
        map=WeixinUtil.xmlToMap(notifyData);
        String resign=map.get("sign");
        String sign=WeixinUtil.generateSignature(map,WeixinConstants.APIKEY);

        //1. 验证签名
        if(resign.equals(sign)){
            //2. 支付的状态
            String return_code=map.get("return_code");
            if(!"SUCCESS".equals(return_code)){
                log.error("【微信支付】异步通知, 返回状态不是成功, return_code={}", return_code);
                throw new SellException(ResultEnum.NOSUCCESS);
            }else{
                //充值订单编号
                String out_trade_no=map.get("out_trade_no");
                //查询充值订单
                Recharge recharge = rechargeMapper.selectByOuttradeno(out_trade_no);
                if(recharge == null){
                    log.error("【微信支付】异步通知, 订单不存在, out_trade_no={}", out_trade_no);
                    throw new SellException(ResultEnum.ORDER_NOT_EXIST);
                }
                Integer totalFee=recharge.getTotalFee();
                String retotalFee=map.get("total_fee");
                //判断金额是否一致(0.10   0.1)total_fee
                if (!MathUtil.equals(totalFee.doubleValue(), Double.valueOf(retotalFee))) {
                    log.error("【微信支付】异步通知, 订单金额不一致, out_trade_no={}, 微信通知金额={}, 系统金额={}",
                            out_trade_no,
                            retotalFee,
                            totalFee);
                    throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
                }
                Recharge inrecharge = new Recharge();
                inrecharge.setStatus("1");//0:正在充值,1:充值成功,2:充值失败
//                inrecharge.setUpdateTime(new Date());
//                inrecharge.setUpdateName(recharge.getUserName());
//                inrecharge.setUpdateId(recharge.getUserId());
                inrecharge.setRechargeOrdernum(out_trade_no);//recharge_ordernum
                //修改订单的支付状态
                num=rechargeMapper.updateByOutTradeNo(inrecharge);
                return num;
            }
        }else{
            log.error("【微信支付】异步通知, 签名不正确, sign={}", sign);
            throw new SellException(ResultEnum.SIGNFAIL);
        }
    }

    /**
     *
     * Description: 将传入的json转为map
     * @param decParams
     * @return
     * @throws Exception
     * @return Map<String,Object> 返回类型
     * @Author chengqiang
     * Create Date: 2015-4-8 上午11:29:27
     *
     */
    public Map<String, Object> paramToMap(String decParams) throws Exception{

        JSONObject jsonObject = JSONObject.fromObject(decParams);
        Map<String, Object> map = JsonUtil.convJsonToMap(jsonObject+"");
        return map;
    }

    /**
     * 微信订单查询接口
     * @param outTradeNo
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderqueryVO> orderqueryByOutTradeNo(String outTradeNo) throws Exception{
        List<OrderqueryVO> list = new ArrayList<>();

        //参数转换为Map
        Map<String,String> map=orderqueryparamsToMap(outTradeNo);

        //将Map转换为XML格式的字符串
        String str = WeixinUtil.mapToXml(map);
        //调查询订单接口
        String returnXMLStr=WeixinUtil.httpRequest(str,WeixinConstants.DEFAULT_CONNECT_TIMEOUT_MS,WeixinConstants.DEFAULT_READ_TIMEOUT_MS,WeixinConstants.ORDERQUERY_URL);
        //XML格式字符串转换为Map
        Map<String, String> xmlToMap = WeixinUtil.xmlToMap(returnXMLStr);
        OrderqueryVO orderqueryVO = new OrderqueryVO();
        orderqueryVO=MapToBeanUtil.map2Bean(orderqueryVO,xmlToMap);
        list.add(orderqueryVO);
        return list;
    }

    //参数转换为Map
    public Map<String,String> orderqueryparamsToMap(String outTradeNo) throws Exception {
        //参数转换为Map
        Map<String,String> map = new HashMap<>();
        //公众账号ID(必填)
        map.put("appid", WeixinConstants.APPID);
        //商户号(必填)
        map.put("mch_id", WeixinConstants.MCHID);
        //商户订单号
        map.put("out_trade_no", outTradeNo);
        //随机字符串(必填)
        map.put("nonce_str", WeixinUtil.generateNonceStr());
        //签名(必填)
        //签名要放到最后
        String sign=WeixinUtil.generateSignature(map,WeixinConstants.APIKEY);
        map.put("sign", sign);
        return map;
    }

}
