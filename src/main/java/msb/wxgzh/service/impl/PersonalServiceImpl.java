package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.PersonalMapper;
import msb.wxgzh.pojo.Personal;
import msb.wxgzh.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalMapper personalMapper;

    public Personal selectPersonalByid(Long userId) {

        return personalMapper.selectByUserId(userId);
    }

}
