package msb.wxgzh.mapper;

import msb.wxgzh.pojo.Recharge;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RechargeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);

    Recharge selectByOuttradeno(String out_trade_no);

    int updateByOutTradeNo(Recharge inrecharge);

}