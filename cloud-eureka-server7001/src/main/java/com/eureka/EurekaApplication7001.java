package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName EurekaApplication
 * @Descrption TODO
 * @date 2022/7/13 10:33
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication7001 {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
