package msb.wxgzh.service;

import msb.wxgzh.pojo.Personal;
import msb.wxgzh.pojo.Recharge;
import msb.wxgzh.vo.OrderqueryVO;
import msb.wxgzh.vo.WeixinUnifiedReturnVO;
import java.util.List;

public interface WeixinService {

    WeixinUnifiedReturnVO getUnifiedOrder(Recharge recharge) throws Exception;

    List<Personal> getUserInfo(Personal personal) throws Exception;

    Integer notify(String notifyData) throws Exception;

//    void getOpenid(WeixinUnifiedOrderVO weixinUnifiedOrderVO) throws Exception;
    List<OrderqueryVO> orderqueryByOutTradeNo(String outTradeNo) throws Exception;

}
