package msb.wxgzh.vo;

import lombok.Data;

@Data
public class OrderqueryVO {

    //返回状态码,SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
    private String return_code;

    //返回信息,当return_code为FAIL时返回信息为错误原因 ，例如
    //签名失败
    //参数格式校验错误
    private String return_msg;

    //以下字段在return_code为SUCCESS的时候有返回

    //公众账号ID
    private String appid;
    //商户号
    private String mch_id;
    //随机字符串
    private String nonce_str;
    //签名
    private String sign;
    //业务结果,SUCCESS/FAIL
    private String result_code;
    //错误代码,当result_code为FAIL时返回错误代码，详细参见下文错误列表
    private String err_code;
    //错误代码描述,当result_code为FAIL时返回错误描述，详细参见下文错误列表
    private String err_code_des;

    //以下字段在return_code 、result_code、trade_state都为SUCCESS时有返回 ，如trade_state不为 SUCCESS，则只返回out_trade_no（必传）和attach（选传）。

    //设备号,微信支付分配的终端设备号
    private String device_info;
    //用户标识
    private String openid;
    //是否关注公众账号,用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
    private String is_subscribe;
    //交易类型,调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
    private String trade_type;
    //交易状态,
    //    SUCCESS—支付成功
    //    REFUND—转入退款
    //    NOTPAY—未支付
    //    CLOSED—已关闭
    //    REVOKED—已撤销（刷卡支付）
    //    USERPAYING--用户支付中
    //    PAYERROR--支付失败(其他原因，如银行返回失败)
    //    支付状态机请见下单API页面
    private String trade_state;

    //付款银行,银行类型，采用字符串类型的银行标识
    private String bank_type;
    //标价金额,订单总金额，单位为分
    private Integer total_fee;
    //应结订单金额,当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
    private Integer settlement_total_fee;
    //标价币种,	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String fee_type;
    //现金支付金额,	现金支付金额订单现金支付金额，详见支付金额
    private Integer cash_fee;
    //现金支付币种,	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String cash_fee_type;
    //代金券金额,“代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额
    private Integer coupon_fee;
    //代金券金额,代金券使用数量
    private Integer coupon_count;

    //代金券类型,
    // CASH--充值代金券
    //NO_CASH---非充值优惠券
    //开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
    private String coupon_type_$n;
    //代金券ID，代金券ID, $n为下标，从0开始编号
    private String coupon_id_$n;
    //单个代金券支付金额，	单个代金券支付金额, $n为下标，从0开始编号
    private Integer coupon_fee_$n;
    //微信支付订单号，代金券ID, $n为下标，从0开始编号
    private String transaction_id;
    //商户订单号，商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
    private String out_trade_no;
    //附加数据，附加数据，原样返回
    private String attach;
    //支付完成时间，订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
    private String time_end;
    //交易状态描述，对当前查询订单状态的描述和下一步操作的指引
    private String trade_state_desc;
}
