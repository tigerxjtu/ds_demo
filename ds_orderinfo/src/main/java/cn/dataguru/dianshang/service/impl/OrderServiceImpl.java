package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.dao.OrderDetailDao;
import cn.dataguru.dianshang.dao.OrderInfoDao;
import cn.dataguru.dianshang.entity.Orderdetail;
import cn.dataguru.dianshang.entity.Ordermain;
import cn.dataguru.dianshang.service.OrderService;
import cn.dataguru.dianshang.timer.OrderRefreshTimer;
import cn.dataguru.dianshang.timer.OrderTimer;
import cn.dataguru.dianshang.vo.CustomOrderInfo;
import cn.dataguru.dianshang.vo.OrderInfoVo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private Scheduler scheduler;

    private List<Ordermain> cachedOrders=new ArrayList<>();

    @Override
    @Transactional
    public void insertOrder(Ordermain ordermain, List<Orderdetail> orderdetaillist) {
        ordermain.setCreatetime(new Date());
        ordermain.setPaystatus(1);
        ordermain.setOrderstatus(1);
        orderInfoDao.insertOrderMain(ordermain);
        long ordermainid = ordermain.getId();
        for(Orderdetail orderdetail : orderdetaillist ){
            orderdetail.setCreatetime(new Date());
            orderdetail.setOrderid(ordermainid);
            orderDetailDao.insertOrderDetail(orderdetail);
        }
    }

    @Override
    public List<Ordermain> findOrderByVo(CustomOrderInfo customOrderInfo) {
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setCustomOrderInfo(customOrderInfo);
        return orderInfoDao.findOrderByVo(orderInfoVo);
    }

    @Override
    public void updateOrderInfoById(Ordermain ordermain) {
        orderInfoDao.updateOrderInfoById(ordermain);
    }

    @Override
    public Ordermain findOrderInfoById(long id) {
        return orderInfoDao.findOrderInfoById(id);
    }

    @Override
    public void updateOrderInfoStatus(Ordermain ordermain) {
        orderInfoDao.updateOrderInfoStatus(ordermain);
    }

    @Override
    public void checkOrderTime() {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = OrderTimer.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(OrderTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refreshOrderTime() {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = OrderTimer.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 5 * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(OrderRefreshTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refreshOrders() {
        cachedOrders = findOrderByVo(null);
    }

    @Override
    public List<Ordermain> getCachedOrders() {
        return cachedOrders;
    }
}
