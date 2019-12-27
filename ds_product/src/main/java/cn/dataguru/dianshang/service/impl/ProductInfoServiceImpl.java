package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.ProductDetailDao;
import cn.dataguru.dianshang.dao.ProductInfoDao;
import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.service.ProductService;
import cn.dataguru.dianshang.vo.CustomProductInfo;
import cn.dataguru.dianshang.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private ProductDetailDao productDetailDao;

    @Override
    @Transactional
    public void issueProduct(ProductInfo productInfo, ProductDetail productDetail) {
        productInfo.setCreatetime(new Date());
        productInfo.setAuditstate(0);
        productInfo.setProudctstatus(0);
        Long successnum = productInfoDao.insertProduct(productInfo);
        if(productDetail != null){
            productDetail.setProductid(productInfo.getId());
            productDetailDao.insertProductDetail(productDetail);
        }
    }

    @Override
    public Long updateProductAuditStatus(long id, int state) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setAuditstate(state);
        return productInfoDao.updateProductAuditStatus(productInfo);
    }

    @Override
    public Long updateProductStatus(long id, int state) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setProudctstatus(state);
        return productInfoDao.updateProductStatus(productInfo);
    }

    @Override
    public List<ProductInfo> queryByVo(CustomProductInfo constomProductInfo) {
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setCustomProductInfo(constomProductInfo);
        return productInfoDao.queryByVo(productInfoVo);
    }
}
