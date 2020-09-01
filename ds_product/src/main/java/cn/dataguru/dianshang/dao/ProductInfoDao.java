package cn.dataguru.dianshang.dao;

import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoDao {
    public Long  insertProduct(ProductInfo productInfo);
    public Long updateProductAuditStatus(ProductInfo productInfo);
    public Long updateProductStatus(ProductInfo productInfo);
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo);

    public ProductInfo findProductById(Long id);
    public ProductInfo updateProductInfo(Long id, String productTile, double productPrice);
}
