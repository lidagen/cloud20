package com.ws.springcloud.service;

import com.ws.springcloud.common.result.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrixFallbackService implements OrderFeignHystrixService {
    @Override
    public CommonResult getOK(Integer id) {
        return new CommonResult("getOK,error");
    }

    @Override
    public CommonResult timeout(Integer id) {
        return new CommonResult("timeout,error");
    }
}
