package msb.wxgzh.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonToMap {

    /**
     *
     * Description: 将传入的json转为map
     * @param decParams
     * @return
     * @throws Exception
     * @return Map<String,Object> 返回类型
     * @Author chengqiang
     * Create Date: 2015-4-8 上午11:29:27
     *
     */
    public Map<String, Object> paramToMap(String decParams) throws Exception{

        JSONObject jsonObject = JSONObject.fromObject(decParams);
        Map<String, Object> map = JsonUtil.convJsonToMap(jsonObject+"");
        return map;
    }

//    /**
//     *
//     * Description: 将传入的json转为list map
//     * @param decParams
//     * @param handle
//     * @return
//     * @throws Exception
//     * @return Map<String,Object> 返回类型
//     * @Author zhanghao
//     * Create Date: 2017-6-3 上午11:29:27
//     *
//     */
//    public List<Map<String, Object>> paramToList(String decParams, String handle) throws Exception{
//        JSONArray ja = JSONArray.fromObject(decParams);
//        List<Map<String,Object>> list2map = JSONArray.toList(ja, HashMap.class);
//        return list2map;
//    }
}
