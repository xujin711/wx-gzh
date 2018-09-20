package msb.wxgzh.controller;

import msb.wxgzh.common.ResultResponse;
import msb.wxgzh.pojo.Personal;
import msb.wxgzh.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PersonalController {


    @Autowired
    private PersonalService personalService;
    /* @RequestMapping(value ="/personalCore/{id}",method = RequestMethod.GET)
    public Personal personalCore(@PathVariable(value = "id") Long id){

         Personal personal = personalService.selectPersonalByid(id);
         if(null !=personal){
             return personal;
         }else {
             return null;
         }

     }*/

    /**
     * 个人中心接口
     * @param userId
     * @return
     */
    @RequestMapping(value ="/personalCore/{userId}",method = RequestMethod.GET)
    public ResultResponse<Personal> personalCore(@PathVariable(value = "userId") Long userId){
        ResultResponse<Personal> response = new ResultResponse<>();

        Personal personal = personalService.selectPersonalByid(userId);
        if(null !=personal){
            response.setMessage("查询成功");
            response.setStatusCode(200);
            response.setResult(personal);
        }else {
            response.setMessage("查询失败");
            response.setStatusCode(500);
        }
            return response;
    }



}
