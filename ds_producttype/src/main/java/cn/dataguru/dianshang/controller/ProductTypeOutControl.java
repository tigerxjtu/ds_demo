package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("productOutType")
public class ProductTypeOutControl {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "list")
    public List<ProductTypeInfo> listAllProductType(long parentId){
        CustomProductTypeInfo constomProductTypeInfo = new CustomProductTypeInfo();
        constomProductTypeInfo.setParentid(parentId);
        List<ProductTypeInfo> list = productTypeService.findProductTypeByVo(constomProductTypeInfo);
        return list;
    }


}
