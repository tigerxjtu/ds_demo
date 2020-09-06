package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("merchant")
public class MerchantControl {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public String findById(@RequestParam long merchantId, Model model){
        MerchantInfo merchantInfo = merchantService.findById(merchantId);
        model.addAttribute("merchantInfo",merchantInfo);
        return "viewMerchant";

    }
}
