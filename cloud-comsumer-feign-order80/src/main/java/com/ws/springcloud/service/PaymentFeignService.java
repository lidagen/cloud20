package com.ws.springcloud.service;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.entites.payment.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value =  "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/feign/timeOut")
    CommonResult<String> timeOut();

}
