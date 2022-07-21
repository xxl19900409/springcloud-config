package com.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentApplication
 * @Descrption TODO
 * @date 2022/7/13 17:23
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {

    public static void main(String[] args){
        SpringApplication.run(PaymentApplication.class,args);
    }
}
