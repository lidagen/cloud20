package com.ws.springcloud.controller;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.entites.payment.Payment;
import com.ws.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * USER: wang_s
 * DATE：2020/3/8
 * DESC：
 **/
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){

        return new CommonResult<>(paymentService.create(payment));
    }

    @GetMapping(value="/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){

        return new CommonResult<>(paymentService.getById(id));
    }

    @GetMapping(value = "/discovery")
    public CommonResult<Object> discoveryClient(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("======>"+instance.getInstanceId()+"\t"+instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return new CommonResult<>(services);
    }

    /**服务发现**/
    @GetMapping(value = "/getLb")
    public CommonResult<Object> getLb(){

        return new CommonResult<>(serverPort);
    }

    /**3秒超时**/
    @GetMapping(value = "/feign/timeOut")
    public CommonResult<String> timeOut(){

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return new CommonResult<>(serverPort);
    }
}
