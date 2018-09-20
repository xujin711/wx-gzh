package msb.wxgzh.mapper;

import msb.wxgzh.pojo.Invoce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InvoceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Invoce record);

    int insertSelective(Invoce record);

    Invoce selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Invoce record);

    int updateByPrimaryKey(Invoce record);
}