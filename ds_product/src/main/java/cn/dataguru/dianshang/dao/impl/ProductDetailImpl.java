package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.ProductDetailDao;
import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.mapper.ProductDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailImpl implements ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public void insertProductDetail(ProductDetail productDetail) {
        productDetailMapper.insertProductDetail(productDetail);
    }
}
