package cn.dataguru.dianshang.entity;

import lombok.Data;

@Data
public class OrderTotal {
    private Ordermain ordermain;
    private Orderdetail orderdetail;
}
