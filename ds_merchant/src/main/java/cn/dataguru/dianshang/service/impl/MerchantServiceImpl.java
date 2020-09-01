package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.MerchantInfoDao;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.service.MerchantService;

import cn.dataguru.dianshang.vo.CustomMerchantInfo;
import cn.dataguru.dianshang.vo.MerchantInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantInfoDao merchantInfoDao;


    @Override
    @Transactional
    public void issueMerchant(MerchantInfo merchantInfo) {
        merchantInfo.setAuditstatus(1);
        merchantInfo.setSoldout(1);
        Long successnum = merchantInfoDao.insertMerchant(merchantInfo);
    }

    @Override
    public Long updateMerchantAuditStatus(long id, int state) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(id);
        merchantInfo.setAuditstatus(state);
        return merchantInfoDao.updateMerchantAuditStatus(merchantInfo);
    }

    @Override
    public Long updateMerchantStatus(long id, int state) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(id);
        merchantInfo.setSoldout(state);
        return merchantInfoDao.updateMerchantStatus(merchantInfo);
    }

    @Override
    public List<MerchantInfo> queryByVo(CustomMerchantInfo constomMerchantInfo) {
        MerchantInfoVo merchantInfoVo = new MerchantInfoVo();
        merchantInfoVo.setCustomMerchantInfo(constomMerchantInfo);
        return merchantInfoDao.queryByVo(merchantInfoVo);
    }

    @Override
    public MerchantInfo findMerchantById(Long id) {
        MerchantInfo merchantInfo = merchantInfoDao.findMerchantById(id);
        return merchantInfo;
    }

    @Override
    public MerchantInfo updateMerchantById(Long id, String merchantname, String merchantaccount,
                                           String merchantpassword, String merchantscope) {
        return merchantInfoDao.updateMerchantInfo(id, merchantname,merchantaccount,merchantpassword,merchantscope);
    }
}
