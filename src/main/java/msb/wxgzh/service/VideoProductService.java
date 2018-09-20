package msb.wxgzh.service;

import msb.wxgzh.pojo.VideoProduct;

import java.util.List;

public interface VideoProductService {
    List<VideoProduct> selectVideoProductByUser(Long UserId);
}
