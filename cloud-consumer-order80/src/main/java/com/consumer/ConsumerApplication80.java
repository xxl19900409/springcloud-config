package com.consumer;

import com.ribbon.rule.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName ConsumerApplication
 * @Descrption TODO
 * @date 2022/7/12 22:18
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service",configuration = RandomRule.class)
@EnableDiscoveryClient
public class ConsumerApplication80 {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerApplication80.class, args);
    } 
}
