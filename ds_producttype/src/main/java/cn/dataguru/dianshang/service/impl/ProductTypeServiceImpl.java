package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.ProductTypeDao;
import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;
import cn.dataguru.dianshang.vo.ProductTypeInfoVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "productTypeFallback")
    public ProductTypeInfo findProductTypeById(long id) {
        ProductTypeInfo productTypeInfo = productTypeDao.findProductTypeById(id);
        if (productTypeInfo==null)
            throw new RuntimeException("ProductTypeInfo is null");
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

    public ProductTypeInfo productTypeFallback(long id){
        ProductTypeInfo productTypeInfo=new ProductTypeInfo();
        productTypeInfo.setProducttypename("未知类别");
        productTypeInfo.setParentid(-1L);
        productTypeInfo.setId(0L);
        ProductTypeInfo productTypeInfo1 = new ProductTypeInfo();
        productTypeInfo1.setProducttypename("没有父类");
        productTypeInfo.setParent(productTypeInfo1);
        return productTypeInfo;
    }

    @Override
    public List<ProductTypeInfo> findProductTypeByVo(CustomProductTypeInfo customProductTypeInfo) {
        ProductTypeInfoVo productTypeInfoVo = new ProductTypeInfoVo();
        productTypeInfoVo.setConstomProductTypeInfo(customProductTypeInfo);
        return productTypeDao.findProductTypeByVo(productTypeInfoVo);
    }
}
