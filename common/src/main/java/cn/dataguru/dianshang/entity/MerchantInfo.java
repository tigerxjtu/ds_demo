package cn.dataguru.dianshang.entity;

import lombok.Data;

@Data
public class MerchantInfo {

    private Long id;
    private String merchantname;
    private String merchantaccount;
    private String merchantpassword;
    private String merchantscope;
    private int auditstatus; //审核状态：1提交成功，2审核通过，3审核不通过
    private int soldout; //1,正常，2,下架

}
