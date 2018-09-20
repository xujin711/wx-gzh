package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.UserMapper;
import msb.wxgzh.pojo.User;
import msb.wxgzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 调试练习接口
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateType(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public List<User> selectUser(Long id) {
        return userMapper.selectUserByid(id);
    }

    @Override
    public Integer deletesUser(User user) {
        return userMapper.deletesUser(user);
    }


}
