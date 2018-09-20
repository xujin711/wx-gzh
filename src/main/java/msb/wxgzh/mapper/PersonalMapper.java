package msb.wxgzh.mapper;

import msb.wxgzh.pojo.Personal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Personal record);

    int insertSelective(Personal record);

    Personal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);

    Personal selectByUnionid(String openid);

    Personal selectByUserId(Long userId);
}