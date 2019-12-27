package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.vo.CustomProductInfo;

import java.util.List;

public interface ProductService {
    public void issueProduct(ProductInfo productInfo, ProductDetail productDetail);
    public Long updateProductAuditStatus(long id, int auditstate);
    public Long updateProductStatus(long id, int state);
    public List<ProductInfo> queryByVo(CustomProductInfo customProductInfo);
}
