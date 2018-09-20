package msb.wxgzh.service;

import msb.wxgzh.pojo.User;

import java.util.List;

public interface UserService {
    Integer insertUser(User user);

    Integer updateType(User user);

    List<User> selectUser(User user);

    List<User> selectUser(Long id);

    Integer deletesUser(User user);



}
