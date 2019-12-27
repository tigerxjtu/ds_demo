package cn.dataguru.dianshang.entity;

import lombok.Data;

@Data
public class ProductTypeInfo {
    private Long id;
    private String producttypename;
    private String  producttypedescription;
    private Long  typegrade;
    private Long parentid;
    private ProductTypeInfo parent;

}
