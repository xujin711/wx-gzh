package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.ViewMapper;
import msb.wxgzh.pojo.View;
import msb.wxgzh.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewMapper viewMapper;
    @Override
    public Integer insertPersonalView(View view) {
        return viewMapper.insert(view);
    }
}
