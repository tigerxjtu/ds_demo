package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.ProductTypeDao;
import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.mapper.ProductTypeMapper;
import cn.dataguru.dianshang.vo.ProductTypeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeImpl implements ProductTypeDao {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public void insertProductType(ProductTypeInfo productTypeInfo) {
        productTypeMapper.insertProductType(productTypeInfo);
    }

    @Override
    public void updateProductTypeById(ProductTypeInfo productTypeInfo) {
        productTypeMapper.updateProductTypeById(productTypeInfo);
    }

    @Override
    public ProductTypeInfo findProductTypeById(long id) {
        return productTypeMapper.findProductTypeById(id);
    }

    @Override
    public List<ProductTypeInfo> findProductTypeByVo(ProductTypeInfoVo productTypeInfoVo) {
        return productTypeMapper.findProductTypeByVo(productTypeInfoVo);
    }
}
