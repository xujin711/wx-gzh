package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.VideoProduct;
import msb.wxgzh.service.VideoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoProductController {

    @Autowired
    private VideoProductService videoProductService;

    /**
     * 视频定制作品列表查询接口
     * @param
     * @return
     */
    @RequestMapping(value ="/selectVideoProductList/{UserId}",method = RequestMethod.GET)
    public ResultResponse<List<VideoProduct>> selectVideoProductList(@PathVariable(value = "UserId") Long UserId){
        ResultResponse<List<VideoProduct>> response = new ResultResponse<>();
        System.out.println(UserId);

        List<VideoProduct> list = videoProductService.selectVideoProductByUser(UserId);
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
