package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchantOut")
public class MerchantOutController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public MerchantInfo findById(@RequestParam long merchantId, Model model){
        MerchantInfo merchantInfo = merchantService.findMerchantById(merchantId);
        return merchantInfo;

    }
}
