package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.*;
import cn.dataguru.dianshang.service.ProductService;
import cn.dataguru.dianshang.service.SendOrderInfoService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping(value="order")
@Controller
public class OrderControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private SendOrderInfoService sendOrderInfoService;

    @RequestMapping(value = "tobuy")
    public String tobuy(long productId, long num,Model model){
        ProductTotal productTotal = productService.findById(productId);
        model.addAttribute("productTotal",productTotal);
        model.addAttribute("num",num);
        return "beautiful/insertOrder";
    }


    @RequestMapping(value = "insertOrder")
    public String insertOrder(long productid, Ordermain ordermain, long productnum, HttpServletRequest request){
        HttpSession session = request.getSession();
        Object value = session.getAttribute("userinfo");
        if(value == null){
            return "toLoginUser";
        }
        UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
        Orderdetail orderdetail = new Orderdetail();
        ProductTotal productTotal = productService.findById(productid);
        orderdetail.setMerchantid(productTotal.getProductInfo().getMechartid());
        orderdetail.setTradenum(productnum);
        orderdetail.setProductid(productid);
        ordermain.setUserid(userinfo.getId());
        OrderTotal orderTotal = new OrderTotal();
        orderTotal.setOrdermain(ordermain);
        orderTotal.setOrderdetail(orderdetail);
        String result = JSONObject.toJSONString(orderTotal);
        sendOrderInfoService.send_2(result);
        return "beautiful/orderSuccess";
    }
}
