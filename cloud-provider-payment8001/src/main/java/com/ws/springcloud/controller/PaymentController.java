package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.entites.payment.Payment;
import com.ws.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * USER: wang_s
 * DATE：2020/3/8
 * DESC：
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){

        return new CommonResult<>(paymentService.create(payment));
    }

    @GetMapping(value="/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){

        return new CommonResult<>(paymentService.getById(id));
    }
}
