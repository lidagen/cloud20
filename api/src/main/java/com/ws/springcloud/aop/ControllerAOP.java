package com.ws.springcloud.aop;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.exc.AppException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
@Slf4j
public class ControllerAOP {

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        CommonResult<?> result;

        try {
            result = (CommonResult<?>) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    /**
     * 封装异常信息，注意区分已知异常（自己抛出的）和未知异常
     */
    private CommonResult<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        CommonResult<?> result = new CommonResult();

        // 已知异常
        if (e instanceof AppException) {
            result.setMessage(e.getLocalizedMessage());
            result.setCode(401);/*
        } else if (e instanceof UnloginException) {
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);*/
        } else {
            log.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMessage(e.toString());
            result.setCode(400);
        }

        return result;
    }
}
