package cn.dataguru.dianshang.service.impl;

import cn.dataguru.dianshang.config.OrderConfigure;
import cn.dataguru.dianshang.entity.OrderTotal;
import cn.dataguru.dianshang.entity.Orderdetail;
import cn.dataguru.dianshang.entity.Ordermain;
import cn.dataguru.dianshang.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveOrderInfo {

    @Autowired
    private OrderService orderService;

    /**
     * === 在RabbitMQ上创建queue,exchange,binding 方法二：直接在@RabbitListener声明 begin ===
     * 接收
     * @param content
     */
    @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
            value = @Queue(value = OrderConfigure.SPRING_BOOT_QUEUE+"3", durable = "true", autoDelete="true"),
            exchange = @Exchange(value = OrderConfigure.SPRING_BOOT_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = OrderConfigure.SPRING_BOOT_BIND_KEY)
    )
    public void receive_2(String content) {
        System.out.println("[ReceiveOrderInfo] receive msg: " + content);
        OrderTotal orderTotal = JSONObject.parseObject(content,OrderTotal.class);
        Orderdetail orderdetail = orderTotal.getOrderdetail();
        Ordermain ordermain = orderTotal.getOrdermain();
        List<Orderdetail> detailList = new ArrayList<Orderdetail>();
        detailList.add(orderdetail);
        orderService.insertOrder(ordermain,detailList);
    }

}
