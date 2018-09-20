package msb.wxgzh.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * FlexJson封装工具类
 * @author liufei
 *
 */
public class JsonUtil {
	/**
	 * 将对象转换成json字符串
	 * 指定需要排除的属性
	 * @param obj
	 * @return
	 */
	public static String jsonExcEncode(Object obj, String... excPropNames){
		JSONSerializer serializer = new JSONSerializer();
		batchExc(serializer, excPropNames);
		return serializer./*exclude("*.class").*/serialize(obj);
	}
	/**
	 * 
	 * Description: 将对象转换成json字符串
	 * @param excPropNames 指定需要排除的属性
	 * @param secPropNames 指定需要安全过滤的属性
	 * @return String
	 * @throws
	 * @Author liufei
	 * Create Date: 2014年5月29日 下午3:41:17
	 */

	/**
	 * 将对象转换成json字符串
	 * 指定需要排除的属性
	 * 深层序列化
	 * @param obj
	 * @param excPropNames
	 * @return
	 */
	public static String jsonExcDeepEncode(Object obj, String... excPropNames){
		JSONSerializer serializer = new JSONSerializer();
		batchExc(serializer, excPropNames);
		return serializer./*exclude("*.class").*/deepSerialize(obj);
	}

	/**
	 * 将对象转换成json字符串
	 * 指定需要序列化的属性
	 * @param obj
	 * @param incPropNames
	 * @return
	 */
	public static String jsonIncEncode(Object obj, String... incPropNames){
		JSONSerializer serializer = new JSONSerializer();
		batchInc(serializer, incPropNames);
		serializer.exclude("*");
		return serializer.serialize(obj);
	}

	/**
	 * 将对象转换成json字符串
	 * 指定需要序列化的属性
	 * 深层序列化
	 * @param obj
	 * @param incPropNames
	 * @return
	 */
	public static String jsonIncDeepEncode(Object obj, String... incPropNames){
		JSONSerializer serializer = new JSONSerializer();
		batchInc(serializer, incPropNames);
		serializer.exclude("*");
		return serializer.deepSerialize(obj);
	}

	/**
	 * 将Json字符串转换为mapList
	 * @param json
	 * @return
	 */
	public static List<Map<String,Object>> convJsonToMapList(String json){
		JSONDeserializer<List<Map<String,Object>>> deserializer = new JSONDeserializer<List<Map<String,Object>>>();
		List<Map<String,Object>> mapList = deserializer.use(null, ArrayList.class).deserialize(json);
		
		return mapList;
	}
	/**
	 * 将Json字符串转换为map
	 * @param json
	 * @return
	 */
	public static Map<String,Object> convJsonToMap(String json){
		JSONDeserializer<Map<String,Object>> deserializer = new JSONDeserializer<Map<String,Object>>();
		Map<String,Object> map = (Map<String,Object>)deserializer.use(null, HashMap.class).deserialize(json);
		
		return map;
	}
	
	/**
	 * 
	 * Description: 将json字符串转换为对象
	 * @param
	 * @return Object
	 * @throws
	 * @Author liufei
	 * Create Date: 2014年9月4日 下午1:51:05
	 */
	public static Object convJsonToObject(String json){
		JSONDeserializer deserializer = new JSONDeserializer();
		return deserializer.deserialize(json);
	}
	
	/*================================ helpers =====================================*/
	/**
	 * 
	 * Description: 批量排除属性
	 * @param
	 * @return void
	 * @throws
	 * @Author liufei
	 * Create Date: 2014年5月29日 下午3:39:12
	 */
	private static void batchExc(JSONSerializer serializer,
			String... excPropNames) {
		if(null != excPropNames && excPropNames.length>0){
			for(String propName: excPropNames){
				if(null!=propName && propName.trim().length()>0) serializer.exclude("*."+propName);
			}
		}
	}
	/**
	 * 
	 * Description: 批量包含属性
	 * @param
	 * @return void
	 * @throws
	 * @Author liufei
	 * Create Date: 2014年5月29日 下午3:44:25
	 */
	private static void batchInc(JSONSerializer serializer,
			String... incPropNames) {
		if(null != incPropNames && incPropNames.length>0){
			for(String propName: incPropNames){
				if(null!=propName && propName.trim().length()>0) serializer.include("*."+propName);
			}
		}
	}

}
