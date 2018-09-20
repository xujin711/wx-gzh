package msb.wxgzh.mappers;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
 /*Mapper接口：基本的增、删、改、查方法
 MySqlMapper：针对MySQL的额外补充接口，支持批量插入*/
public interface  MyMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
