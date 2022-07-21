package com.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName RandomRule
 * @Descrption TODO
 * @date 2022/7/15 17:17
 */
@Configuration
public class RandomRule {

    @Bean
    public IRule createRule(){
        return new com.netflix.loadbalancer.RandomRule();
    }
}
