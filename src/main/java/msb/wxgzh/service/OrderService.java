package msb.wxgzh.service;

import msb.wxgzh.pojo.Orders;

import java.util.List;

public interface OrderService {
     List<Orders> selectOrderByUser(Long UserId);
   // List<Order> selectOrder(Long id);




}
