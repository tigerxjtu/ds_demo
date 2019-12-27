package cn.dataguru.dianshang.entity;

import lombok.Data;

@Data
public class ProductDetail {
    private long id;
    private Long productid;
    private String productplace;
    private String productdescription;
    private String productbrand;
    private String productweight;
    private String productspecification;
    private String productdetaipicurl;

}
