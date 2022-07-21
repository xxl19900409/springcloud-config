package com.consumer.controller;

import com.consumer.lb.LoadBalance;
import com.entity.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalance loadBalance;

//    private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @RequestMapping("/pay/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        CommonResult payment = restTemplate.getForObject(PAYMENT_URL + "/payment/sel/" + id, CommonResult.class);
        return payment;
    }

    @RequestMapping("/blTest")
    public CommonResult blTest(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        instances.forEach(instance->{
//            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
//        });

        ServiceInstance serviceInstance = loadBalance.getServiceInstance(instances);
        CommonResult payment = restTemplate.getForObject("http://"+serviceInstance.getServiceId() + "/payment/sel/1", CommonResult.class);
        return payment;
    }
}
