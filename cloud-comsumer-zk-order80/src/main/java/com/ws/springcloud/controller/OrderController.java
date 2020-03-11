package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * USER: wang_s
 * DATE：2020/3/11
 * DESC：
 **/
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private final static String URL = "http://cloud-payment-service";

    @GetMapping("/payment/zk")
    public CommonResult getServerPort(){
        return restTemplate.getForObject(URL+"/payment/zk",CommonResult.class);
    }
}
