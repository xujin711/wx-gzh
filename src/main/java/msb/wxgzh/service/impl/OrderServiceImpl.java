package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.OrdersMapper;
import msb.wxgzh.pojo.Orders;
import msb.wxgzh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> selectOrderByUser(Long userId) {
        List<Orders> list = new ArrayList<>();
        List<Orders> retlist = new ArrayList<>();
        Orders orders = new Orders();
        list=ordersMapper.selectByUserId(userId);
        for (int i=0;i<list.size();i++){
            orders=list.get(i);
            Date date = orders.getCreateTime();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String str=sdf.format(date);
            try {
                date=sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            orders.setCreateTime(date);
            retlist.add(orders);
        }
        return retlist;
    }


    /* public List<Order> selectOrder(Long id){
        return orderMapper.selectOrderByid(id);

    }*/

}
