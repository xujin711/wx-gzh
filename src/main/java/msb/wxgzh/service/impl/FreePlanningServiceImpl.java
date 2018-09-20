package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.FreePlanningMapper;
import msb.wxgzh.pojo.FreePlanning;
import msb.wxgzh.service.FreePlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreePlanningServiceImpl implements FreePlanningService {

    @Autowired
    private FreePlanningMapper freePlanningMapper;

    @Override
    public Integer insertFreePlanning(FreePlanning freePlanning){
        return freePlanningMapper.insert(freePlanning);
    }
}
