package msb.wxgzh.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.PropertyUtils;
/**
 *
 * @ClassName: MapToBeanUtil
 * @Description: 反射工具类
 * @author
 * @date
 *
 */
public class MapToBeanUtil {

    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
    public static <T> T map2Bean(T t,Map map)  throws Exception{
        Class<? extends Object> clazz = t.getClass();
        Set<String> keys = map.keySet();
        //变量map 赋值
        for(String key:keys){
            String fieldName = key;
            //设置赋值
            try {
                Object object = map.get(key);
                if(object == null){
                    continue;
                }
                Class paramClass = PropertyUtils.getPropertyType(t, key);

                //类型数据处理
                if(paramClass == XMLGregorianCalendar.class){
                    object = DateUtil4Dis.getXMLDateTime(object.toString());
                }else if(paramClass == BigDecimal.class){
                    object = new BigDecimal(object.toString());
                }else if(paramClass == String.class){
                    object = object.toString();
                }else if(paramClass == Date.class){
                    object = new Date(new Long(object.toString()));
                }else if(paramClass == Integer.class){
                    object = Integer.parseInt(object.toString());
                }else if(paramClass == int.class){
                    object = Integer.parseInt(object.toString());
                }

                if(PropertyUtils.isWriteable(t, key.toString())){
                    PropertyUtils.setProperty(t, key.toString(), object);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("属性【"+fieldName+"】转换异常");
            }
        }

        return t;
    }


}
