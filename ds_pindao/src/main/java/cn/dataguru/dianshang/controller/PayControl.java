package cn.dataguru.dianshang.controller;


import cn.dataguru.dianshang.service.ZhiFuBaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("pay")
public class PayControl {

    @Autowired
    private ZhiFuBaoPayService zhiFuBaoPayService;

    @RequestMapping(value = "payWithAmoutbyzhifubao")
    public String payWithAmoutbyzhifubao(int orderid){
            return zhiFuBaoPayService.payWithAmoutbyzhifubao(orderid);
    }

    @RequestMapping(value = "notifyzhifubao")
    public void notifyzhifubao(HttpServletRequest request){
        System.out.println("notifyzhifubao");
//        zhiFuBaoPayService.notifyzhifubao(request);
    }

    @RequestMapping(value = "returnzhifubao")
    public String returnzhifubao(HttpServletRequest request){
        System.out.println("returnzhifubao");
        return "returnzhifubao";
//        return zhiFuBaoPayService.returnzhifubao(request);
    }

}
