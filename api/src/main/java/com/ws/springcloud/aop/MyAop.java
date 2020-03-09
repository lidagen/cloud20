package com.ws.springcloud.aop;

import com.ws.springcloud.common.result.CommonResult;
import com.ws.springcloud.exc.AppException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
@Component
@Aspect
@Slf4j
public class MyAop {

    /**
     * 定义切入点，切入点为  opController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public com.ws.springcloud.common.result.CommonResult *(..))")
    public void MyAop(){

    }

    @Around("MyAop()")
    public CommonResult<?> processAuthority(ProceedingJoinPoint pjp) throws Throwable{
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
            result.setMessage(e.getMessage());
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
