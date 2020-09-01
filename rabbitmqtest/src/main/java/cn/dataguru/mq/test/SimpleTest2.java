package cn.dataguru.mq.test;

import cn.dataguru.mq.RabbitMqStarter;
import cn.dataguru.mq.receive.ReceiveMsg2;
import cn.dataguru.mq.send.SendMsg2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RabbitMqStarter.class, value = "spring.profiles.active=boot")
public class SimpleTest2 {

    @Autowired
    private ReceiveMsg2 receiveMsg2;

    @Autowired
    private SendMsg2 sendMsg2;

    @Test
    public void sendAndReceive_2(){
        String testContent = "send msg by youfan";
        sendMsg2.send_2(testContent);
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

