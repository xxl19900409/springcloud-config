package com.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName ConsumerConfig
 * @Descrption TODO
 * @date 2022/7/12 22:19
 */
@Configuration
public class ConsumerConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
