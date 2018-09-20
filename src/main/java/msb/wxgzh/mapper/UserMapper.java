package msb.wxgzh.mapper;

import msb.wxgzh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserMapper {
    int insert(User user);
    int updateUser(User user);
    List<User> selectUser(User user);
    List<User> selectUserByid(Long id);
    int deletesUser(User user);

}
