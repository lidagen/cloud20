package com.ws.springcloud.service;

import com.ws.springcloud.common.result.CommonResult;

public interface PaymentHystrixService {

     String payment_OK(Integer id);

     String payment_FAIL(Integer id);

     String getInteger(Integer id);
}
