package com.ws.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
