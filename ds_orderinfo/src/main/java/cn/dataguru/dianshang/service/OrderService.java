package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.Orderdetail;
import cn.dataguru.dianshang.entity.Ordermain;
import cn.dataguru.dianshang.vo.CustomOrderInfo;

import java.util.List;

public interface OrderService {

    public void insertOrder(Ordermain ordermain, List<Orderdetail> orderdetaillist);
    public List<Ordermain> findOrderByVo(CustomOrderInfo customOrderInfo);
    public void updateOrderInfoById(Ordermain ordermain);
    public Ordermain findOrderInfoById(long id);
    public void updateOrderInfoStatus(Ordermain ordermain);
    public void checkOrderTime();
    public void refreshOrderTime();
    public void refreshOrders();
    public List<Ordermain> getCachedOrders();
}
