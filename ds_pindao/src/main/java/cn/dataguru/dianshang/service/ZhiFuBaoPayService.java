package cn.dataguru.dianshang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "ds-pay")
public interface ZhiFuBaoPayService {

    /**
     * @return 1支付成功 2支付失败
     */
    @RequestMapping(value = "zhifubao/payWithAmoutbyzhifubao")
    public String payWithAmoutbyzhifubao(@RequestParam(value = "orderid") int orderid);


    @RequestMapping(value = "zhifubao/notifyzhifubao")
    public void notifyzhifubao(@RequestBody HttpServletRequest request) ;

    @RequestMapping(value = "zhifubao/returnzhifubao")
    public String returnzhifubao(@RequestBody HttpServletRequest request);
}
