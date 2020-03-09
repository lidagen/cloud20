package com.ws.springcloud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
@Component
@Aspect

public class MyAop {

    /**
     * 定义切入点，切入点为  opController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    /*@Pointcut("execution(public * com.ws.springcloud.common.result.CommonResult*(..)))")
    public void MyAop(){

    }*/

}
