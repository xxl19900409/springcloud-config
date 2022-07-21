package com.consumer.controller;

import com.consumer.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName ConsumerController
 * @Descrption TODO
 * @date 2022/7/18 21:58
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "default_fallback")
public class ConsumerController {

    @Autowired
    private PaymentFeignService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String s = paymentService.payment_ok(id);
        return s;
    }

//    @HystrixCommand(fallbackMethod = "payment_timeout_fallback",commandProperties={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

//    @HystrixCommand
    @GetMapping("/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String s = paymentService.payment_timeout(id);
        return s;
    }

//    public String payment_timeout_fallback(Integer id){
//        return "降级";
//    }

    public String default_fallback(){
        return "default fallback";
    }
}
