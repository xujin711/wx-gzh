package msb.wxgzh.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//微信统一下单接口入参
public class WeixinUnifiedOrderVO {

    private Long id;

    private Long userId;

    private String userName;

    //充值金额
    private BigDecimal amount;
    //当前余额
    private BigDecimal balanceAmount;

    private Date createTime;

    private String status;

    private Long updateId;

    private String updateName;

    private Date updateTime;

    private String isDel;

    //公众账号ID(必填)微信支付分配的公众账号ID（企业号corpid即为此appId）
    private String appid;
    //商户号(必填)微信支付分配的商户号
    private String mch_id;
    //设备号(非必填)	自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
    private String device_info;
    //随机字符串(必填)随机字符串，长度要求在32位以内。推荐随机数生成算法
    private String nonce_str;
    //签名(必填)通过签名算法计算得出的签名值，详见签名生成算法
    private String sign;
    //签名类型(非必填)签名类型，默认为MD5，支持HMAC-SHA256和MD5。
    private String sign_type;
    //商品描述(必填)商品简单描述，该字段请按照规范传递，具体请见参数规定
    private String body;
    //商品详情(非必填)商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
    private String detail;
    //附加数据(非必填)附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
    private String attach;
    //商户订单号(必填)商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
    private String out_trade_no;
    //标价币种(非必填)符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
    private String fee_type;
    //标价金额(必填)订单总金额，单位为分，详见支付金额
    private int total_fee;
    //终端IP(必填)APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
    private String spbill_create_ip;
    //交易起始时间(非必填)订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
    private String time_start;
    //交易结束时间(非必填)订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则
    //建议：最短失效时间间隔大于1分钟
    private String time_expire;
    //订单优惠标记(非必填)订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠
    private String goods_tag;
    //通知地址(必填)异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
    private String notify_url;
    //交易类型(必填)
    //JSAPI 公众号支付
    //NATIVE 扫码支付
    //APP APP支付
    //说明详见参数规定
    private String trade_type;
    //商品ID(非必填)trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    private String product_id;
    //指定支付方式 (非必填)上传此参数no_credit--可限制用户不能使用信用卡支付
    private String limit_pay;
    //用户标识 (非必填)trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
    private String openid;
    //场景信息(非必填)该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
    private List<WeixinSceneInfoVO> scene_info;

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

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<WeixinSceneInfoVO> getScene_info() {
        return scene_info;
    }

    public void setScene_info(List<WeixinSceneInfoVO> scene_info) {
        this.scene_info = scene_info;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
