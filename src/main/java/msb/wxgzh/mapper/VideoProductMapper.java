package msb.wxgzh.mapper;

import msb.wxgzh.pojo.VideoProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoProduct record);

    int insertSelective(VideoProduct record);

    VideoProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VideoProduct record);

    int updateByPrimaryKey(VideoProduct record);

    List<VideoProduct>  selectVideoProductByUser(Long userId);

}