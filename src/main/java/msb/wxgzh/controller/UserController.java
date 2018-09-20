//package msb.wxgzh.controller;
//
//import msb.wxgzh.common.ResultResponse;
//import msb.wxgzh.common.UserType;
//import msb.wxgzh.pojo.User;
//import msb.wxgzh.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//
///**
// * 调试练习接口
// */
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/geren",method = RequestMethod.POST)
//    public ResultResponse<Void> geren(HttpServletRequest request, User user){
//        ResultResponse<Void> response = new ResultResponse<>();
//        //User user = new User();
//        Integer num = userService.insertUser(user);
//        if(num==1){
//            response.setStatus(true);
//            response.setMessage("添加成功");
//        }else{
//            response.setStatus(false);
//            response.setMessage("添加失败");
//        }
//        return response;
//    }
//
//    @RequestMapping(value = "/updateContext",method = RequestMethod.POST)
//    public ResultResponse<Void> updateContext(User user){
//        ResultResponse<Void> response = new ResultResponse<>();
//        Integer num = userService.updateType(user);
//        if(num==1){
//            response.setStatus(true);
//            response.setMessage("修改成功");
//        }else{
//            response.setStatus(false);
//            response.setMessage("修改失败");
//        }
//        return response;
//    }
//
//    @RequestMapping(value = "/selectType",method = RequestMethod.POST)
//    public List<User> selectType(User user){
//        List<User> list = userService.selectUser(user);
//        if(list.size()>0 && list != null){
//            return list;
//        }else
//            return null;
//    }
//    @RequestMapping(value = "/selectTypeByid/{userId}",method = RequestMethod.GET)
//    public List<User> selectTypeByid(@PathVariable(value = "userId") Long id){
//        List<User> list = userService.selectUser(id);
//        if(list.size()>0 && list != null){
//            return list;
//        }else
//            return null;
//    }
//
//    @RequestMapping(value = "/deletesType",method = RequestMethod.POST)
//    public ResultResponse<Void> deletesType(User user){
//        ResultResponse<Void> response = new ResultResponse<>();
//        Integer num = userService.deletesUser(user);
//        if(num > 0){
//            response.setStatus(true);
//            response.setMessage("删除成功");
//        }else{
//            response.setStatus(false);
//            response.setMessage("删除失败");
//        }
//        return response;
//    }
//
//
//}
