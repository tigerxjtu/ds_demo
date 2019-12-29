package cn.dataguru.dianshang.timer;

import cn.dataguru.dianshang.entity.Ordermain;
import cn.dataguru.dianshang.service.OrderService;
import cn.dataguru.dianshang.utils.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

public class OrderRefreshTimer extends QuartzJobBean {

    @Autowired
    private OrderService orderService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("哈哈哈");
        orderService.refreshOrders();
    }
}
