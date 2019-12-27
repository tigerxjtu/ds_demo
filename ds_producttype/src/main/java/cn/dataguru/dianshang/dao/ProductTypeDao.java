package cn.dataguru.dianshang.dao;

import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.vo.ProductTypeInfoVo;

import java.util.List;

public interface ProductTypeDao {
    public void insertProductType(ProductTypeInfo productTypeInfo);
    public void updateProductTypeById(ProductTypeInfo productTypeInfo);
    public ProductTypeInfo findProductTypeById(long id);
    public List<ProductTypeInfo> findProductTypeByVo(ProductTypeInfoVo productTypeInfoVo);
}
