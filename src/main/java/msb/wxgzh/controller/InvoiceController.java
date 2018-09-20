package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.Invoce;
import msb.wxgzh.pojo.Orders;
import msb.wxgzh.pojo.View;
import msb.wxgzh.service.InvoceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoceService invoceService;
    /**
     * 发票订单查询接口
     * @param
     * @return
     */
    @RequestMapping(value ="/selectInvoceList/{UserId}",method = RequestMethod.GET)
    public ResultResponse<List<Orders>> selectInvoceList(@PathVariable(value = "UserId") Long UserId){
        ResultResponse<List<Orders>> response = new ResultResponse<>();
        System.out.println(UserId);

        List<Orders> list = invoceService.selectInvoceByUser(UserId);
        if(list !=null && list.size()>0){
            response.setMessage("发票订单查询成功");
            response.setStatusCode(200);
            response.setResult(list);
        }else {
            response.setMessage("发票订单查询失败");
            response.setStatusCode(500);
        }
        return response;

    }

    /**
     * 开发票保存接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/submitInvoce",method = RequestMethod.POST)
    public ResultResponse<Void> submitInvoce(@RequestBody Invoce invoce){
        ResultResponse<Void> response = new ResultResponse<>();

        Integer num = invoceService.insertInvoce(invoce);
        if(num == 1){
            response.setMessage("发票提交成功");
            response.setStatusCode(200);
        }else {
            response.setMessage("发票提交失败");
            response.setStatusCode(500);
        }
        return response;
    }
}
