package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * USER: wang_s
 * DATE：2020/3/11
 * DESC：
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public CommonResult serverInformation() {

        return new CommonResult("serverPort:"+serverPort+"UUID:"+"\t" +UUID.randomUUID());
    }
}
