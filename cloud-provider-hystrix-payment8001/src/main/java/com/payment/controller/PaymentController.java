package com.payment.controller;

import com.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentController
 * @Descrption TODO
 * @date 2022/7/18 21:07
 */

@Slf4j
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String s = paymentService.payment_ok(id);
        log.info("*****result:{}",s);
        return s;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String s = paymentService.payment_timeout(id);
        log.info("*****result:{}",s);
        return s;
    }

    @GetMapping("/hystrix/break/{id}")
    public String payment_break(@PathVariable("id") Integer id){
        String s = paymentService.payment_break(id);
        log.info("*****result:{}",s);
        return s;
    }
}
