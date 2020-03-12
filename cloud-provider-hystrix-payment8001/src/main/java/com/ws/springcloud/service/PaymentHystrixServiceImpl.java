package com.ws.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ws.springcloud.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * USER: wang_s
 * DATE：2020/3/12
 * DESC：
 **/
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"payment_OK,id:" + id+"===>"+"OKOK";
    }

    @HystrixCommand(fallbackMethod = "payInfo_TimeoutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String payment_FAIL(Integer id) {
        int time = id * 1000;
        //int i = 10 / 0;
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"payment_Timeout,id:" + id+"===>"+"OUT +333+ OUT";
    }


    private String payInfo_TimeoutHandle(Integer id){
        return "线程池："+Thread.currentThread().getName()+"8001系統繁忙或运行错误，請稍候再試,id:" + id+"===>"+"超时啦！！！";

    }
}
