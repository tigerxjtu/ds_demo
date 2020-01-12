package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ds-product")
public interface ProductService {

    @RequestMapping(value = "productOut/queryAll",method = RequestMethod.GET)
    public List<ProductInfo> queryAll(@RequestParam(value = "productTypeid") long productTypeid);
}
