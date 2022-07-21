package com.consumer.lb.impl;

import com.consumer.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.StreamHandler;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName LoabalanceInstance
 * @Descrption TODO
 * @date 2022/7/18 10:24
 */
@Slf4j
@Component
public class LoabalanceInstance implements LoadBalance {

    /*访问次数*/
    private AtomicInteger atomicInteger;
    {
        atomicInteger = new AtomicInteger(0);
    }

    /**
     * @Description: 获取到服务下标
     * @Author: xiaxl
     * @return:
     **/
    private final int getAndIncrement(int modulo){
        int next;
        int current;
        do{
            current=atomicInteger.get();
            next=current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("----request times:{}",next);
        log.info("index :{}",next%modulo);
        return next%modulo;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        log.info("instances  :{}",instances.size());
        return instances.get(getAndIncrement(instances.size()));
    }
}
