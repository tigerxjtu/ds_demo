package cn.dataguru.dianshang.mapper;


import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.vo.MerchantInfoVo;

import java.util.List;

public interface MerchantMapper {
    public Long insertMerchant(MerchantInfo merchantInfo);
    public Long updateMerchantAuditStatus(MerchantInfo merchantInfo);
    public Long updateMerchantStatus(MerchantInfo merchantInfo);
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo);

    public MerchantInfo findMerchantById(MerchantInfo merchantInfo);
    public Long updateMerchantInfo(MerchantInfo merchantInfo);
}
