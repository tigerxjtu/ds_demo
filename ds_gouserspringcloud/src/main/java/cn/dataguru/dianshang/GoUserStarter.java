package cn.dataguru.dianshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableEurekaClient
@EnableSidecar
public class GoUserStarter {

    public static void main(String[] args) {

        SpringApplication.run(GoUserStarter.class,args);
    }
}
