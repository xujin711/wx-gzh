package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.UserInfo;
import msb.wxgzh.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 预约咨询客户信息保存接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/submitUserInfo",method = RequestMethod.POST)
    public ResultResponse<Void> submitUserInfo(@RequestBody UserInfo userInfo){
        ResultResponse<Void> response = new ResultResponse<>();

        //必填字段校验
//        Long userId = userInfo.getUserId();
//        if(null==userId){
//            response.setMessage("预约咨询客户信息提交失败,userid为空");
//            response.setStatusCode(500);
//            return response;
//        }
        String userName = userInfo.getUserName();
        if(StringUtils.isBlank(userName)){
            response.setMessage("预约咨询客户信息提交失败,userName为空");
            response.setStatusCode(500);
            return response;
        }
//        String userSex = userInfo.getUserSex();
//        if(StringUtils.isBlank(userSex)){
//            response.setMessage("预约咨询客户信息提交失败,userSex为空");
//            response.setStatusCode(500);
//            return response;
//        }
//        String userSex = userInfo.getUserSex();
//        if(StringUtils.isBlank(userSex)){
//            response.setMessage("预约咨询客户信息提交失败,userSex为空");
//            response.setStatusCode(500);
//            return response;
//        }

        String userTelephone = userInfo.getUserTelephone();
        if(StringUtils.isBlank(userTelephone)){
            response.setMessage("预约咨询客户信息提交失败,userTelephone为空");
            response.setStatusCode(500);
            return response;
        }
        Date userDate = userInfo.getUserDate();
        if(null==userDate){
            response.setMessage("预约咨询客户信息提交失败,userDate为空");
            response.setStatusCode(500);
            return response;
        }
        Integer num = userInfoService.insertUserInfo(userInfo);
        if(num == 1){
            response.setMessage("预约咨询客户信息提交成功");
            response.setStatusCode(200);
        }else {
            response.setMessage("预约咨询客户信息提交失败");
            response.setStatusCode(500);
        }
        return response;
    }
}
