package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.OrderDetailDao;
import cn.dataguru.dianshang.entity.Orderdetail;
import cn.dataguru.dianshang.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public void insertOrderDetail(Orderdetail orderdetail) {
        orderDetailMapper.insertOrderDetail(orderdetail);
    }
}
