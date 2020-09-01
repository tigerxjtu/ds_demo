package cn.dataguru.dianshang.dao;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.vo.MerchantInfoVo;
import cn.dataguru.dianshang.vo.ProductInfoVo;

import java.util.List;

public interface MerchantInfoDao {
    public Long  insertMerchant(MerchantInfo merchantInfo);
    public Long updateMerchantAuditStatus(MerchantInfo merchantInfo);
    public Long updateMerchantStatus(MerchantInfo merchantInfo);
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo);

    public MerchantInfo findMerchantById(Long id);
    public MerchantInfo updateMerchantInfo(Long id, String merchantname, String merchantaccount,
                                           String merchantpassword,String merchantscope);
}
