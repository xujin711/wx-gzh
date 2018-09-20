package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.RechargeMapper;
import msb.wxgzh.pojo.Recharge;
import msb.wxgzh.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeServiceImpl implements RechargeService {


    @Autowired
    private RechargeMapper rechargeMapper;

    @Override
    public Integer insertRecharge(Recharge recharge) {
        return rechargeMapper.insert(recharge);
    }
}
