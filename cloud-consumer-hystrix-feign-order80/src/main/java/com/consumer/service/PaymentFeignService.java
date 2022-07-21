package com.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentFeignService
 * @Descrption TODO
 * @date 2022/7/18 21:57
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/pay/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/pay/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);

}
