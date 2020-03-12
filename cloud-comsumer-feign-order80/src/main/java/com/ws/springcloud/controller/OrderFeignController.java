package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.entites.payment.Payment;
import com.ws.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/12
 * DESC：
 **/
@RestController
@RequestMapping("/feign")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @GetMapping(value = "/timeOut")
    CommonResult<String> timeOut(){
        return paymentFeignService.timeOut();
    }
}
