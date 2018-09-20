package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.View;
import msb.wxgzh.service.ViewService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ViewController {


    @Autowired
    private ViewService ViewService;


    /**
     * 意见反馈接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/submitView",method = RequestMethod.POST)
    public ResultResponse<Void> submitView(@RequestBody View view){
        ResultResponse<Void> response = new ResultResponse<>();
        //必填字段校验
        Long createId = view.getCreateId();
        if(null==createId){
            response.setMessage("意见提交失败,createId为空");
            response.setStatusCode(500);
            return response;
        }
        String context = view.getContext();
        if(StringUtils.isBlank(context)){
            response.setMessage("意见提交失败,context为空");
            response.setStatusCode(500);
            return response;
        }
        Integer num = ViewService.insertPersonalView(view);
        if(num == 1){
            response.setMessage("意见提交成功，审核中");
            response.setStatusCode(200);
        }else {
            response.setMessage("意见提交失败");
            response.setStatusCode(500);
        }
            return response;
    }



}
