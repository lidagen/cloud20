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
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        if (result > 0){
            return new CommonResult<>(200,"成功");
        }
        return new CommonResult(400,"插入数据库失败");
    }

    @GetMapping(value="/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){

        Payment payment = paymentService.getById(id);
        if (null != payment){
            return new CommonResult<>(200,"success",payment);
        }
        return new CommonResult<>(400,"error");
    }
}
