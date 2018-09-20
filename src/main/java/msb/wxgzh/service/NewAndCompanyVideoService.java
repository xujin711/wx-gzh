package msb.wxgzh.service;

import msb.wxgzh.pojo.NewAndCompanyVideo;

public interface NewAndCompanyVideoService {
    NewAndCompanyVideo selectVideoByUser(Long UserId);
}
