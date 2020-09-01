package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.ProductDetailDao;
import cn.dataguru.dianshang.dao.ProductInfoDao;
import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.entity.ProductTotal;
import cn.dataguru.dianshang.service.ProductService;
import cn.dataguru.dianshang.service.SearchService;
import cn.dataguru.dianshang.vo.CustomProductInfo;
import cn.dataguru.dianshang.vo.ProductInfoVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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


    @Autowired
    private SearchService searchService;

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
        JSONObject jsonObject = (JSONObject)JSON.toJSON(productInfo);
        searchService.addData(jsonObject,"youfands","product",""+productInfo.getId());
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

    @Override
    public ProductTotal findProductById(Long id) {
        ProductTotal productTotal = new ProductTotal();
        ProductInfo productInfo = productInfoDao.findProductById(id);
        ProductDetail productDetail = productDetailDao.findProductDetailByProductId(id);
        productTotal.setProductInfo(productInfo);
        productTotal.setProductDetail(productDetail);
        return productTotal;
    }

    @Override
    public ProductInfo updateProductById(Long id, String productTile, double productPrice) {
        return productInfoDao.updateProductInfo(id, productTile,productPrice);
    }
}
