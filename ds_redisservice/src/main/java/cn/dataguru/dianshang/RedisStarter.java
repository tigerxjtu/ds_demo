package cn.dataguru.dianshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RedisStarter {

    public static void main(String[] args) {

        SpringApplication.run(RedisStarter.class,args);
    }
}
