package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/productType")
public class ProductTypeControl {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("toInsert")
    public String toInsertProductType(){
        return "insertProductType";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public void insertProductType(ProductTypeInfo productTypeInfo){
        productTypeService.insertProductType(productTypeInfo);
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public String findProductTypeById(long id, Model model){
        ProductTypeInfo productTypeInfo = productTypeService.findProductTypeById(id);
        ProductTypeInfo parent = productTypeInfo.getParent();
        model.addAttribute("productTypeInfo",productTypeInfo);
        model.addAttribute("parent",parent);
        return "viewProductType";
    }

    @RequestMapping("toUpdate")
    public String toUpdateProductType(Long id,Model model){
        ProductTypeInfo productTypeInfo = productTypeService.findProductTypeById(id);
        ProductTypeInfo parent = productTypeInfo.getParent();
        model.addAttribute("productTypeInfo",productTypeInfo);
        model.addAttribute("parent",parent);
        return "updateProductType";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String updateProductType(ProductTypeInfo productTypeInfo){
        productTypeService.updateProductTypeById(productTypeInfo);
        return "redirect:list";
    }

    @RequestMapping(value = "list")
    public String listProductType(CustomProductTypeInfo constomProductTypeInfo,Model model){
        List<ProductTypeInfo> list = productTypeService.findProductTypeByVo(constomProductTypeInfo);
        model.addAttribute("list",list);
        return "list";
    }


}
