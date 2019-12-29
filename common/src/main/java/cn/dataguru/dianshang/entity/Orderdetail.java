package cn.dataguru.dianshang.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Orderdetail {
    private Long id;
  private Long orderid;
  private Long productid;
  private Long merchantid;
  private Date createtime;
  private Long tradenum;

}
