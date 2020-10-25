package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.ProductInfo;
import cn.dataguru.dianshang.entity.ProductTotal;
import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductService;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.service.RedisService;
import cn.dataguru.dianshang.service.SearchService;
import cn.dataguru.dianshang.util.IPSpiderUtil;
import cn.dataguru.dianshang.util.SpiderPreUtil;
import cn.dataguru.dianshang.vo.EsPage;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("productlist")
public class ProductControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "listProduct")
    public String listProductByTypeId(long productypeid, Model model){
        List<ProductInfo> list = productService.queryAll(productypeid);
        List<ProductTypeInfo> productTypeInfoList = productTypeService.listAllProductType(-1);
        model.addAttribute("list",list);
        model.addAttribute("typelist",productTypeInfoList);
        return "listProduct";

    }

    @RequestMapping(value = "/indexproduct")
    public String indexproduct(long productypeid, Model model,HttpServletRequest req,HttpServletResponse rep){
        SpiderPreUtil.setCookies(req,rep);
        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        if(productypeid == -1){
            productypeid = list.get(0).getId();
        }
        List<ProductInfo> productlist = productService.queryAll(productypeid);
        List<List<ProductInfo>> productlistfinal = new ArrayList<List<ProductInfo>>();
        List<ProductInfo> innerlist = new ArrayList<ProductInfo>();
        for(int i=0;i<productlist.size();i++){
            innerlist.add(productlist.get(i));
            if((i+1)%3==0){
                productlistfinal.add(innerlist);
                innerlist = new ArrayList<ProductInfo>();
            }
        }
        if(productlist.size()%3 != 0){
            productlistfinal.add(innerlist);
        }
        model.addAttribute("productlistfinal",productlistfinal);
        return "beautiful/index";
    }

    @RequestMapping(value = "/searchProduct")
    public String searchProduct(String searchword, Model model){
        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        long productypeid = list.get(0).getId();
        EsPage esPage = searchService.searchDataPage("youfands","product",0,1,false,"producttitle","productprice","producttitle",searchword,"producttitle,productprice,auditstate,proudctstatus,stocknum,auditstate,productpicurl");
        List<Map<String, Object>> resultList = esPage.getRecordList();
        List<ProductInfo> productlist = new ArrayList<ProductInfo>();
        for(Map<String,Object> map:resultList){
            ProductInfo productInfo =  JSONObject.parseObject(JSONObject.toJSONString(map),ProductInfo.class);
            productlist.add(productInfo);
        }
        List<List<ProductInfo>> productlistfinal = new ArrayList<List<ProductInfo>>();
        List<ProductInfo> innerlist = new ArrayList<ProductInfo>();
        for(int i=0;i<productlist.size();i++){
            innerlist.add(productlist.get(i));
            if((i+1)%3==0){
                productlistfinal.add(innerlist);
                innerlist = new ArrayList<ProductInfo>();
            }
        }
        if(productlist.size()%3 != 0){
            productlistfinal.add(innerlist);
        }
        model.addAttribute("productlistfinal",productlistfinal);
        return "beautiful/index";
    }

    @RequestMapping(value = "/findProductById")
    public String findProductById(long productId, Model model, HttpServletRequest req, HttpServletResponse response){
        if(!SpiderPreUtil.validateReferer(req,"productlist/indexproduct")){
            return "error";
        }
        if(!SpiderPreUtil.validateCookie(req,response)){
            return "error";
        }
        if(IPSpiderUtil.isPrev(req,redisService)){
            return "error";
        }
        String productTotalString = redisService.getStr("product:"+productId);
        ProductTotal productTotal = null;
        if(StringUtils.isBlank(productTotalString)){
            productTotal = productService.findById(productId);
            String productTotalJson = JSONObject.toJSONString(productTotal);
            redisService.setStr("product:"+productId,productTotalJson);
        }else {
            productTotal = JSONObject.parseObject(productTotalString,ProductTotal.class);
        }

        model.addAttribute("productTotal",productTotal);

        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        return "beautiful/single";
    }
}
