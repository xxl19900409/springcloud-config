package com.consumer.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName Log
 * @Descrption TODO
 * @date 2022/7/18 15:53
 */

@Configuration
public class Log {

    @Bean
    public Logger.Level getLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
