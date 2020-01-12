package cn.dataguru.dianshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PinDaoStarter {
    public static void main(String[] args) {
        SpringApplication.run(PinDaoStarter.class,args);
    }
}
