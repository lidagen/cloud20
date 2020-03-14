package com.ws.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * USER: wang_s
 * DATE：2020/3/14
 * DESC：
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServerCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenter3344.class,args);
    }
}
