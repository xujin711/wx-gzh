package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.NewAndCompanyVideoMapper;
import msb.wxgzh.pojo.NewAndCompanyVideo;
import msb.wxgzh.service.NewAndCompanyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAndCompanyVideoServiceImpl implements NewAndCompanyVideoService {

    @Autowired
    private NewAndCompanyVideoMapper newAndCompanyVideoMapper;

    @Override
    public NewAndCompanyVideo selectVideoByUser(Long UserId) {
        return newAndCompanyVideoMapper.selectVideoByUser(UserId);
    }
}
