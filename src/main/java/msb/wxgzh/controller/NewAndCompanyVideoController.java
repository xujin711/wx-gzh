package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.NewAndCompanyVideo;
import msb.wxgzh.service.NewAndCompanyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewAndCompanyVideoController {

    @Autowired
    private NewAndCompanyVideoService newAndCompanyVideoService;

    /**
     * 最新视频和企业宣传视频查询接口
     * @param
     * @return
     */
    @RequestMapping(value ="/selectNewAndCompanyVideoList/{UserId}",method = RequestMethod.GET)
    public ResultResponse<NewAndCompanyVideo> selectNewAndCompanyVideoList(@PathVariable(value = "UserId") Long UserId){
        ResultResponse<NewAndCompanyVideo> response = new ResultResponse<>();
        System.out.println(UserId);

        NewAndCompanyVideo newAndCompanyVideo = newAndCompanyVideoService.selectVideoByUser(UserId);
        if(null !=newAndCompanyVideo){
            response.setMessage("最新视频和企业宣传视频查询接口查询成功");
            response.setStatusCode(200);
            response.setResult(newAndCompanyVideo);
        }else {
            response.setMessage("最新视频和企业宣传视频查询接口查询失败");
            response.setStatusCode(500);
        }
        return response;

    }

}
