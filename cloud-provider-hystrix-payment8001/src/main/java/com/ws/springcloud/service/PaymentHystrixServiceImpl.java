package com.ws.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.exc.AppException;
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

    /***
     * 服务熔断 传大于0的正常返回，小于O异常
     */

    @Override
    public String getInteger(Integer id) {
        if (id <= 0 ){
            throw new AppException("ERROR");
        }
        return "UUID="+IdUtil.simpleUUID()+ ",返回正常,===>id:" +id;
    }
}
