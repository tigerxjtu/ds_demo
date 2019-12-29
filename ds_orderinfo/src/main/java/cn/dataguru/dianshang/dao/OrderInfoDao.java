package cn.dataguru.dianshang.dao;

import cn.dataguru.dianshang.entity.Ordermain;
import cn.dataguru.dianshang.vo.OrderInfoVo;

import java.util.List;

public interface OrderInfoDao {
    public void insertOrderMain(Ordermain ordermain);
    public List<Ordermain> findOrderByVo(OrderInfoVo orderInfoVo);
    public void updateOrderInfoById(Ordermain ordermain);
    public Ordermain findOrderInfoById(long id);
    public void updateOrderInfoStatus(Ordermain ordermain);
}
