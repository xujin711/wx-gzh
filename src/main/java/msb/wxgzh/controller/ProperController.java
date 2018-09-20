//package msb.wxgzh.controller;
//
//import msb.wxgzh.common.ResultResponse;
//import msb.wxgzh.pojo.Proper;
//import msb.wxgzh.service.ProperService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * 调试练习接口
// */
//@RestController
//public class ProperController {
//
//    @Autowired
//    private ProperService properService;
//
//    @RequestMapping(value = "/insertType",method = RequestMethod.POST)
//    public ResultResponse<Void> insertType(Proper proper){
//        ResultResponse<Void> response = new ResultResponse<>();
//        Integer i = properService.insertProper(proper);
//        if(i == 1){
//            response.setStatus(true);
//            response.setMessage("添加成功");
//            response.setStatusCode(200);
//        }else{
//            response.setStatus(false);
//            response.setMessage("添加失败");
//        }
//        return response;
//    }
//
//    @PostMapping(value ="/selectProper")
//    public List<Proper> selectProper(){
//        List<Proper> propers = properService.SelectProperByType();
//        if(propers.size() > 0 && propers != null){
//            return propers;
//        }else{
//            return null;
//        }
//
//    }
//
//
//
//
//
//   /* @RequestMapping(value = "/insertTypeBylist",method = RequestMethod.POST)
//    public ResultResponse<Void> insertTypeBylist(Proper proper){
//        ResultResponse<Void> response = new ResultResponse<>();
//        Integer i = properService.insertProper(proper);
//        if(i == 1){
//            response.setStatus(true);
//            response.setMessage("添加成功");
//            response.setStatusCode(200);
//        }else{
//            response.setStatus(false);
//            response.setMessage("添加失败");
//        }
//        return response;*/
//
//
//}
