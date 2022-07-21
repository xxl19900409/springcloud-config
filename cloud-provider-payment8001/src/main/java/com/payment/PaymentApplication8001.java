package com.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentApplication
 * @Descrption TODO
 * @date 2022/7/12 15:37
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8001 {
    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication8001.class,args);
    }
}
