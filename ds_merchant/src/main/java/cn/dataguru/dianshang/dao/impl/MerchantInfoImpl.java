package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.MerchantInfoDao;
import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.mapper.MerchantMapper;
import cn.dataguru.dianshang.vo.MerchantInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantInfoImpl implements MerchantInfoDao {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Long insertMerchant(MerchantInfo merchantInfo) {
        return merchantMapper.insertMerchant(merchantInfo);
    }

    @Override
    public Long updateMerchantAuditStatus(MerchantInfo merchantInfo) {
        return merchantMapper.updateMerchantAuditStatus(merchantInfo);
    }

    @Override
    public Long updateMerchantStatus(MerchantInfo merchantInfo) {
        return merchantMapper.updateMerchantStatus(merchantInfo);
    }

    @Override
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo) {
        return merchantMapper.queryByVo(merchantInfoVo);
    }

    @Override
    public MerchantInfo findMerchantById(Long id) {
        System.out.println("findMerchantById");
        MerchantInfo merchantInfo = new MerchantInfo();

        merchantInfo.setId(id);
        return merchantMapper.findMerchantById(merchantInfo);
    }

    @Override
    public MerchantInfo updateMerchantInfo(Long id, String merchantname, String merchantaccount,
                                           String merchantpassword,String merchantscope) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(id);
        merchantInfo.setMerchantname(merchantname);
        merchantInfo.setMerchantaccount(merchantaccount);
        merchantInfo.setMerchantpassword(merchantpassword);
        merchantInfo.setMerchantscope(merchantscope);
        merchantMapper.updateMerchantInfo(merchantInfo);
        return merchantMapper.findMerchantById(merchantInfo);
    }
}
