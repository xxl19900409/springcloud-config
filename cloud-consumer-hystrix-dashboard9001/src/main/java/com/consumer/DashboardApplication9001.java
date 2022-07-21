package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName DashboardApplication9001
 * @Descrption TODO
 * @date 2022/7/19 17:12
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApplication9001 {

    public static void main(String[] args){
        SpringApplication.run(DashboardApplication9001.class,args);
    }
}
