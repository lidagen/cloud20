package com.ws.springcloud.service;

import com.ws.springcloud.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value =  "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = FeignHystrixFallbackService.class)
public interface OrderFeignHystrixService {

     @GetMapping(value = "/payment/hystrix/ok/{id}")
     CommonResult getOK(@PathVariable("id") Integer id);


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    CommonResult timeout(@PathVariable("id") Integer id);

}
