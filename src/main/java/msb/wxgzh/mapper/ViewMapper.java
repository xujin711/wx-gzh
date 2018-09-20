package msb.wxgzh.mapper;

import msb.wxgzh.pojo.View;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(View record);

    int insertSelective(View record);

    View selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(View record);

    int updateByPrimaryKey(View record);
}