package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.entity.ProductTotal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ds-merchant")
public interface MerchantService {

    @RequestMapping(value = "merchantOut/findById",method = RequestMethod.GET)
    public MerchantInfo findById(@RequestParam(value = "merchantId") long merchantId);
}
