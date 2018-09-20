package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.Orders;
import msb.wxgzh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * 订单接口
     * @param
     * @return
     */
    @RequestMapping(value ="/selectOrder/{UserId}",method = RequestMethod.GET)
    public ResultResponse<List<Orders>> selectOrder(@PathVariable(value = "UserId") Long UserId){
      ResultResponse<List<Orders>> response = new ResultResponse<>();
        System.out.println(UserId);

        List<Orders> list = orderService.selectOrderByUser(UserId);
        if(list !=null && list.size()>0){
            response.setMessage("查询成功");
            response.setStatusCode(200);
            response.setResult(list);
        }else {
            response.setMessage("查询失败");
            response.setStatusCode(500);
        }
        return response;

    }
}
