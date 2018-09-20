package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.InvoceMapper;

import msb.wxgzh.mapper.OrdersMapper;
import msb.wxgzh.pojo.Invoce;
import msb.wxgzh.pojo.Orders;
import msb.wxgzh.service.InvoceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoceServiceImpl implements InvoceService {

    @Autowired
    private InvoceMapper invoceMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> selectInvoceByUser(Long UserId) {
        return ordersMapper.selectOrderInvoceByUserId(UserId);
    }

    @Override
    public Integer insertInvoce(Invoce invoce) {
        return invoceMapper.insert(invoce);
    }
}
