package com.ws.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * USER: wang_s
 * DATE：2020/3/12
 * DESC：
 **/
@SpringBootApplication
@EnableFeignClients//feign注解
public class OrderFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class,args);
    }
}
