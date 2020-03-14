package com.ws.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.exc.AppException;
import com.ws.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/12
 * DESC：
 **/
@RestController
@Slf4j
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public CommonResult getOK(@PathVariable("id") Integer id){
        String payment_ok = paymentHystrixService.payment_OK(id);
        log.info("result:" + payment_ok);
        return new CommonResult(payment_ok);
    }


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public CommonResult timeout(@PathVariable("id") Integer id){
        String payment_FAIL = paymentHystrixService.payment_FAIL(id);
        log.info("result:" + payment_FAIL);
        return new CommonResult(payment_FAIL);
    }

    @GetMapping(value = "/payment/hystrix/getId/{id}")
    public String getId(@PathVariable("id") Integer id){

        String getInteger = paymentHystrixService.getInteger(id);
        return getInteger;
    }


}
