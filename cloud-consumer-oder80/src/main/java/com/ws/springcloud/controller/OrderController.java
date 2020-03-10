package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.entites.payment.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    /**CLOUD-PAYMENT-SERVICE是eureka中注册的名称**/
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/payment";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id,CommonResult.class);
    }
}
