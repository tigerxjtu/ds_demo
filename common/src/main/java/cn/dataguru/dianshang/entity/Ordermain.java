package cn.dataguru.dianshang.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Ordermain {
    private Long id;
    private Double payamount;
    private Long userid;
    private Date createtime;
    private Date paytime;
    private int paystatus;//支付状态,1未支付 2已支付 3已退款
    private String consigneeadress;
    private String consigneephone;
    private String consigneename;
    private String tradenumber;
    private int paytype;//支付类型 1微信支付 2支付宝支付 3银联支付
    private int orderstatus;//订单状态  1、正常 2失效'

}
