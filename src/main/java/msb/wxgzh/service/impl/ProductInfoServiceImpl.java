package msb.wxgzh.service.impl;

import msb.wxgzh.mapper.ProductInfoMapper;
import msb.wxgzh.pojo.ProductInfo;
import msb.wxgzh.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Override
    public ProductInfo selectProductInfo(Long id){
        return productInfoMapper.selectByPrimaryKey(id);
    }
}
