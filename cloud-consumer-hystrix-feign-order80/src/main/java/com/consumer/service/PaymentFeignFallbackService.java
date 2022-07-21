package com.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentFeignFallbackService
 * @Descrption TODO
 * @date 2022/7/19 9:58
 */
@Component
public class PaymentFeignFallbackService implements PaymentFeignService{

    @Override
    public String payment_ok(Integer id) {
        return "null";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "通配降级配置";
    }
}
