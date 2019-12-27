package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.ProductInfoDao;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.mapper.ProductMapper;
import cn.dataguru.dianshang.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInfoImpl implements ProductInfoDao {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Long insertProduct(ProductInfo productInfo) {
        return productMapper.insertProduct(productInfo);
    }

    @Override
    public Long updateProductAuditStatus(ProductInfo productInfo) {
        return productMapper.updateProductAuditStatus(productInfo);
    }

    @Override
    public Long updateProductStatus(ProductInfo productInfo) {
        return productMapper.updateProductStatus(productInfo);
    }

    @Override
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo) {
        return productMapper.queryByVo(productInfoVo);
    }
}
