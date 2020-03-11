package com.ws.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * USER: wang_s
 * DATE：2020/3/11
 * DESC：
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain.class,args);
    }
}
