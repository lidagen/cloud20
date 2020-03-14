package com.ws.springcloud.service;

import cn.hutool.core.util.IdUtil;
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

    @Override
    public String getId(Integer id) {
        return "UUID="+ IdUtil.simpleUUID()+ ",===>ERROR";
    }
}
