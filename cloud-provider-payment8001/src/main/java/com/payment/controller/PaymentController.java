package com.payment.controller;

import com.entity.domain.Payment;
import com.entity.result.CommonResult;
import com.payment.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentController
 * @Descrption TODO
 * @date 2022/7/12 17:00
 */

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Payment payment){
        int insert = paymentService.insert(payment);
        if(insert>0){
            return CommonResult.success(serverPort);
        }else{
            return CommonResult.error();
        }
    }

    @GetMapping("/sel/{id}")
    public CommonResult selectPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectPaymentById(id);
        return CommonResult.success(payment,serverPort);
    }

    @GetMapping("/timeout")
    public CommonResult timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  CommonResult.success();
    }

}
