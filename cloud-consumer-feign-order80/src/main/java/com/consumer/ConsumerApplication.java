package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName ConsumerApplication
 * @Descrption TODO
 * @date 2022/7/18 14:55
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
