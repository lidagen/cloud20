package com.ws.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.service.OrderFeignHystrixService;
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
public class OrderFeignHystrixController {
    @Autowired
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping(value = "/client/hystrix/ok/{id}")
    CommonResult getOK(@PathVariable("id") Integer id){
        return orderFeignHystrixService.getOK(id);
    }


    @GetMapping(value = "/client/hystrix/timeout/{id}")
    CommonResult timeout(@PathVariable("id") Integer id){
        CommonResult timeout = orderFeignHystrixService.timeout(id);
        return timeout;
    }


}
