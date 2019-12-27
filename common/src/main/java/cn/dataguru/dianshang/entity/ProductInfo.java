package cn.dataguru.dianshang.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductInfo {
    private long id;
    private long producttypeid;
    private String producttitle;
    private double productprice;
    private long mechartid;
    private Date createtime;
    private Date audittime;
    private int auditstate;//0 未审核 1 审核通过 2 审核不通过
    private int stocknum;
    private long sellnum;
    private String productpicurl;
    private int proudctstatus;
}
