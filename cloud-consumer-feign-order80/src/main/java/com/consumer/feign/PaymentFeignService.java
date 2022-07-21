package com.consumer.feign;

import com.entity.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/sel/{id}")
    public CommonResult selectPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public CommonResult timeout();
}
