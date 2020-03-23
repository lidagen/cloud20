package com.ws.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * USER: wang_s
 * DATE：2020/3/22
 * DESC：
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder80.class, args);
    }
}
