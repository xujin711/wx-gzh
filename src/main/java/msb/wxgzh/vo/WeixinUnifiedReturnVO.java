package msb.wxgzh.vo;

import java.math.BigDecimal;
import java.util.Date;

public class WeixinUnifiedReturnVO {

    private Long id;

    private Long userId;

    private String userName;

    //当前余额
    private BigDecimal balanceAmount;

    private Date createTime;

    private String status;

    //订单号
    private String out_trade_no;

    //返回状态码SUCCESS/FAIL,(必填),此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
    private String return_code;
    //返回信息,(必填),当return_code为FAIL时返回信息为错误原因 ，例如:签名失败,参数格式校验错误
    private String return_msg;

    //公众账号ID,(必填),调用接口提交的公众账号ID
    private String appid;
    //商户号,(必填),调用接口提交的商户号
    private String mch_id;
    //设备号,自定义参数，(非必填),可以为请求支付的终端设备号等
    private String device_info;
    //随机字符串,(必填),微信返回的随机字符串
    private String nonce_str;
    //签名,(必填),微信返回的签名值，详见签名算法
    private String sign;
    //业务结果,(必填),SUCCESS/FAIL
    private String result_code;
    //错误代码,(非必填),当result_code为FAIL时返回错误代码，详细参见下文错误列表
    private String err_code;
    //错误代码描述,(非必填),当result_code为FAIL时返回错误描述，详细参见下文错误列表
    private String err_code_des;

    //交易类型,(必填),
    // JSAPI 公众号支付
    //NATIVE 扫码支付
    //APP APP支付
    //说明详见参数规定
    private String trade_type;
    //预支付交易会话标识,(必填),微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
    private String prepay_id;
    //二维码链接,(非必填),trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
    private String code_url;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
