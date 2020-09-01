package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.MerchantInfo;
import cn.dataguru.dianshang.service.MerchantService;
import cn.dataguru.dianshang.vo.CustomMerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;



    @RequestMapping("toIssue")
    public String toIssueMerchant(){
        return "issueMerchant";
    }

    @RequestMapping(value = "issue",method = RequestMethod.POST)
    public void issueMerchant(MerchantInfo merchantInfo){
        merchantService.issueMerchant(merchantInfo);
    }

    /**
     * 审核
     * @param id
     * @param auditstate
     */
    @RequestMapping(value = "approval",method = RequestMethod.GET)
    public String approvalMerchant(long id, int auditstate){
        merchantService.updateMerchantAuditStatus(id,auditstate);
        return "redirect:queryAll";
    }

    /**
     * 上架 下架
     * @param id
     * @param state
     */
    @RequestMapping(value = "updateStatus",method = RequestMethod.GET)
    public String updateMerchantStatus(long id, int state){
        merchantService.updateMerchantStatus(id,state);
        return "redirect:queryAll";
    }

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public String queryAll(Model model){

        List<MerchantInfo> list = merchantService.queryByVo(null);
        model.addAttribute("list",list);
        return "listMerchant";
    }

    @RequestMapping(value = "queryAllStatusPass",method = RequestMethod.GET)
    public String queryAllStatus(Model model){
        CustomMerchantInfo customMerchantInfo = new CustomMerchantInfo();
        customMerchantInfo.setAuditstatus(1);
        List<MerchantInfo> list = merchantService.queryByVo(customMerchantInfo);
        model.addAttribute("list",list);
        return "listMerchant";
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public String findById(@RequestParam long merchantId, Model model){
        MerchantInfo merchantInfo = merchantService.findMerchantById(merchantId);
        model.addAttribute("merchantInfo",merchantInfo);
        return "viewMerchant";

    }

    @RequestMapping(value = "editById",method = RequestMethod.GET)
    public String editById(@RequestParam long merchantId, Model model){
        MerchantInfo merchantInfo = merchantService.findMerchantById(merchantId);
        model.addAttribute("merchantInfo",merchantInfo);
        return "editMerchant";

    }

    @RequestMapping(value = "updateMerchantById",method = RequestMethod.POST)
    public void updateMerchantBy(@RequestParam long merchantId,@RequestParam String merchantname,
                                 @RequestParam String merchantaccount, @RequestParam String merchantpassword,
                                 @RequestParam String merchantscope){
        MerchantInfo merchantInfo = merchantService.updateMerchantById(merchantId, merchantname,merchantaccount,
                merchantpassword,merchantscope);

    }

}
