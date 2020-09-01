package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.ProductDetailDao;
import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.mapper.ProductDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailImpl implements ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public void insertProductDetail(ProductDetail productDetail) {
        productDetailMapper.insertProductDetail(productDetail);
    }

    @Override
    @Cacheable(value = "ProductCache",key = "'productDetail'+#id")
    public ProductDetail findProductDetailByProductId(Long id) {
        System.out.println("findProductDetailByProductId");
        ProductInfo productInfo = new ProductInfo();
        return  productDetailMapper.findProductDetailByProductId(productInfo);
    }
}
