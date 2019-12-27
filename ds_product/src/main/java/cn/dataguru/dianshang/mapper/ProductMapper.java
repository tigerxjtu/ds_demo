package cn.dataguru.dianshang.mapper;

import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.vo.ProductInfoVo;

import java.util.List;

public interface ProductMapper {
    public Long insertProduct(ProductInfo productInfo);
    public Long updateProductAuditStatus(ProductInfo productInfo);
    public Long updateProductStatus(ProductInfo productInfo);
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo);
}
