package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.ProductTypeDao;
import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;
import cn.dataguru.dianshang.vo.ProductTypeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public void insertProductType(ProductTypeInfo productTypeInfo) {
            productTypeDao.insertProductType(productTypeInfo);
    }

    @Override
    public void updateProductTypeById(ProductTypeInfo productTypeInfo) {
        productTypeDao.updateProductTypeById(productTypeInfo);
    }

    @Override
    public ProductTypeInfo findProductTypeById(long id) {
        ProductTypeInfo productTypeInfo = productTypeDao.findProductTypeById(id);
        if(productTypeInfo.getParentid() != -1){
            ProductTypeInfo parent = productTypeDao.findProductTypeById(productTypeInfo.getParentid());
            productTypeInfo.setParent(parent);
        }else{
            ProductTypeInfo productTypeInfo1 = new ProductTypeInfo();
            productTypeInfo1.setProducttypename("没有父类");
            productTypeInfo.setParent(productTypeInfo1);
        }
        return productTypeInfo;
    }

    @Override
    public List<ProductTypeInfo> findProductTypeByVo(CustomProductTypeInfo customProductTypeInfo) {
        ProductTypeInfoVo productTypeInfoVo = new ProductTypeInfoVo();
        productTypeInfoVo.setConstomProductTypeInfo(customProductTypeInfo);
        return productTypeDao.findProductTypeByVo(productTypeInfoVo);
    }
}
