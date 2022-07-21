package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName GateWayApplication9527
 * @Descrption TODO
 * @date 2022/7/20 15:05
 */
@EnableEurekaClient
@SpringBootApplication
public class GateWayApplication9527 {

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication9527.class,args);
    }
}
