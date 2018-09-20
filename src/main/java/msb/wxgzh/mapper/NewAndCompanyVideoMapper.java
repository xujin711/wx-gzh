package msb.wxgzh.mapper;

import msb.wxgzh.pojo.NewAndCompanyVideo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NewAndCompanyVideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewAndCompanyVideo record);

    int insertSelective(NewAndCompanyVideo record);

    NewAndCompanyVideo selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(NewAndCompanyVideo record);

    int updateByPrimaryKey(NewAndCompanyVideo record);

    NewAndCompanyVideo selectVideoByUser(Long userId);
}