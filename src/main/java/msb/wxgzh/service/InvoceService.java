package msb.wxgzh.service;


import msb.wxgzh.pojo.Invoce;
import msb.wxgzh.pojo.Orders;

import java.util.List;

public interface InvoceService {
    /**
     * 查询发票订单接口
     * @param UserId
     * @return
     */
    List<Orders> selectInvoceByUser(Long UserId);

    Integer insertInvoce(Invoce invoce);

}
