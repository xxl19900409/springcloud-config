package com.consumer.controller;
import com.consumer.feign.PaymentFeignService;
import com.entity.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName ConsumerController
 * @Descrption TODO
 * @date 2022/7/12 22:20
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/pay/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        CommonResult payment = paymentFeignService.selectPaymentById(id);
        return payment;
    }

    @RequestMapping("/timeout")
    public CommonResult timeout(){
        CommonResult payment = paymentFeignService.timeout();
        return payment;
    }

}
