package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.entity.ProductDetail;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.entity.ProductTotal;
import cn.dataguru.dianshang.vo.CustomMerchantInfo;
import cn.dataguru.dianshang.vo.CustomProductInfo;

import java.util.List;

public interface MerchantService {
    public void issueMerchant(MerchantInfo merchantInfo);
    public Long updateMerchantAuditStatus(long id, int auditstate);
    public Long updateMerchantStatus(long id, int state);
    public List<MerchantInfo> queryByVo(CustomMerchantInfo customMerchantInfo);
    public MerchantInfo findMerchantById(Long id);
    public MerchantInfo updateMerchantById(Long id, String merchantname, String merchantaccount,
                                         String merchantpassword,String merchantscope);
}
