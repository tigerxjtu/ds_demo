package cn.dataguru.dianshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryCenterStarter {
    public static void main(String[] args) {
        SpringApplication.run(RegistryCenterStarter.class, args);
    }
}
