package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;

import java.util.List;

public interface ProductTypeService {
    public void insertProductType(ProductTypeInfo productTypeInfo);
    public void updateProductTypeById(ProductTypeInfo productTypeInfo);
    public ProductTypeInfo findProductTypeById(long id);
    public List<ProductTypeInfo> findProductTypeByVo(CustomProductTypeInfo customProductTypeInfo);
}
