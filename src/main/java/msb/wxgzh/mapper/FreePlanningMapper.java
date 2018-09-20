package msb.wxgzh.mapper;

import msb.wxgzh.pojo.FreePlanning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FreePlanningMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FreePlanning record);

    int insertSelective(FreePlanning record);

    FreePlanning selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FreePlanning record);

    int updateByPrimaryKey(FreePlanning record);
}