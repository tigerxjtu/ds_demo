package cn.dataguru.dianshang.controller;

import cn.dataguru.dianshang.entity.ProductTypeInfo;
import cn.dataguru.dianshang.service.ProductTypeService;
import cn.dataguru.dianshang.vo.CustomProductTypeInfo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("productOutType")
public class ProductTypeOutControl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    Integer port;

    @Autowired
    private ProductTypeService productTypeService;


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<ProductTypeInfo> listAllProductType(@RequestParam long parentId){
        CustomProductTypeInfo constomProductTypeInfo = new CustomProductTypeInfo();
        constomProductTypeInfo.setParentid(parentId);
        List<ProductTypeInfo> list = productTypeService.findProductTypeByVo(constomProductTypeInfo);
        return list;
    }

    @RequestMapping(value = "listtype",method = RequestMethod.GET)
    public Map listType(@RequestParam long parentId){
        CustomProductTypeInfo constomProductTypeInfo = new CustomProductTypeInfo();
        constomProductTypeInfo.setParentid(parentId);
        List<ProductTypeInfo> list = productTypeService.findProductTypeByVo(constomProductTypeInfo);
        Map map=new HashMap();
        map.put("server",port);
        map.put("data",list);
        return map;
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(@RequestParam long parentId){
        String url="http://DS-PRODUCTTYPE/productOutType/listtype?parentId={parentId}";
        Map params=new HashMap();
        params.put("parentId",parentId);
        String result=restTemplate.getForObject(url,String.class,params);
        return result;
    }

}
