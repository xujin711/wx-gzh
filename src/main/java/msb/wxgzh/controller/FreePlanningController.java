package msb.wxgzh.controller;

import com.soecode.wxtools.util.StringUtils;
import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.FreePlanning;

import msb.wxgzh.service.FreePlanningService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class FreePlanningController {

    @Autowired
    private FreePlanningService freePlanningService;

    /**
     * 免费策划信息保存接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/submitFreePlan",method = RequestMethod.POST)
    public ResultResponse<Void> submitFreePlan(@RequestBody FreePlanning freePlanning){
        ResultResponse<Void> response = new ResultResponse<>();
        //必填字段校验
        String videoType = freePlanning.getVideoType();
        if(StringUtils.isBlank(videoType)){
            response.setMessage("免费策划信息保存失败,视频类型为空");
            response.setStatusCode(500);
            return response;
        }
        String makeBudget = freePlanning.getMakeBudget();
        if(StringUtils.isBlank(makeBudget)){
            response.setMessage("免费策划信息保存失败,视频制作预算为空");
            response.setStatusCode(500);
            return response;
        }
        String userName = freePlanning.getUserName();
        if(StringUtils.isBlank(userName)){
            response.setMessage("免费策划信息保存失败,联系人姓名为空");
            response.setStatusCode(500);
            return response;
        }
        String userTelephone = freePlanning.getUserTelephone();
        if(StringUtils.isBlank(userTelephone)){
            response.setMessage("免费策划信息保存失败,联系电话为空");
            response.setStatusCode(500);
            return response;
        }

        Integer num = freePlanningService.insertFreePlanning(freePlanning);
        if(num == 1){
            response.setMessage("免费策划信息提交成功");
            response.setStatusCode(200);
        }else {
            response.setMessage("免费策划信息提交失败");
            response.setStatusCode(500);
        }
        return response;
    }
}
