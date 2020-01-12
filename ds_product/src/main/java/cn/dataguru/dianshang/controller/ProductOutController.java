package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.service.ProductService;
import cn.dataguru.dianshang.vo.CustomProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("productOut")
public class ProductOutController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public List<ProductInfo> queryAll(@RequestParam long productTypeid){
        if (productTypeid == -1){
            productTypeid = 4L;
        }
        CustomProductInfo constomProductInfo = new CustomProductInfo();
        constomProductInfo.setProducttypeid(productTypeid);
        List<ProductInfo> list = productService.queryByVo(constomProductInfo);
        return list;
    }









}
