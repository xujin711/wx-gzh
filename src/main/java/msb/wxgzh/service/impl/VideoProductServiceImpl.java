package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.VideoProductMapper;
import msb.wxgzh.pojo.VideoProduct;
import msb.wxgzh.service.VideoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoProductServiceImpl implements VideoProductService {

    @Autowired
    private VideoProductMapper videoProductMapper;

    @Override
    public List<VideoProduct> selectVideoProductByUser(Long UserId) {
        return videoProductMapper.selectVideoProductByUser(UserId);
    }
}
