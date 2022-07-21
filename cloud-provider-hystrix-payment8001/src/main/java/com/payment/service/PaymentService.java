package com.payment.service;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentService
 * @Descrption TODO
 * @date 2022/7/18 21:07
 */
@Service
public class PaymentService {


    public String payment_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+" payment_ok,id="+id+"\t"+" O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "payment_timeout_fallback",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_timeout(Integer id){
        int times=5;
        try {
            TimeUnit.SECONDS.sleep(times);
            FileWriter file=new FileWriter("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" payment_timeout,id="+id+"\t"+" O(∩_∩)O哈哈~"+"\t"+"耗时"+times+"秒";
    }

    public String payment_timeout_fallback(Integer id){
        return "友好线程池："+Thread.currentThread().getName()+" O(∩_∩)O哈哈~";
    }

    /**
     * @Description: 服务熔断测试
     *
     * 10秒内 10次请求 超过50%失败率 就熔断服务
     **/
    @HystrixCommand(fallbackMethod = "payment_break_fallback",commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启熔断 默认就是ture
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//时间窗口 内请求次数 默认20次
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//10秒  默认5秒  时间窗口
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50") //失败率 50%,  默认 也是50%
    })
    public String payment_break(Integer id){
        if(id<0){
            throw  new RuntimeException("*********id 不能为负数");
        }
        String uuid=IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功\\(^o^)/~,流水号："+uuid;
    }

    public String payment_break_fallback(Integer id){
        return "o(╥﹏╥)o 服务熔断了...";
    }


}
