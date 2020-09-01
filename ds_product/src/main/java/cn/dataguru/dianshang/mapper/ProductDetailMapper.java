package cn.dataguru.dianshang.mapper;

import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;

public interface ProductDetailMapper {
    public void insertProductDetail(ProductDetail productDetail);

    public ProductDetail findProductDetailByProductId(ProductInfo productInfo);
}
