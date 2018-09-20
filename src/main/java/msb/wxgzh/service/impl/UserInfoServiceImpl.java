package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.UserInfoMapper;
import msb.wxgzh.pojo.UserInfo;
import msb.wxgzh.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer insertUserInfo(UserInfo userInfo){
        return userInfoMapper.insert(userInfo);
    }
}
