package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.ProductInfo;
import msb.wxgzh.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;
    /**
     * 产品介绍视频查询接口
     * @param
     * @return
     */
    @RequestMapping(value ="/selectProductInfo/{productId}",method = RequestMethod.GET)
    public ResultResponse<ProductInfo> selectProductInfo(@PathVariable(value = "productId") Long UserId) {
        ResultResponse<ProductInfo> response = new ResultResponse<>();
        System.out.println(UserId);

        ProductInfo productInfo = productInfoService.selectProductInfo(UserId);
        if(null !=productInfo){
            response.setMessage("产品介绍视频查询接口查询成功");
            response.setStatusCode(200);
            response.setResult(productInfo);
        }else {
            response.setMessage("产品介绍视频查询接口查询失败");
            response.setStatusCode(500);
        }
        return response;
    }
}
