package com.ws.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/22
 * DESC：
 **/
@RestController
@RefreshScope //刷新配置中心
public class NacosConfigController {
    @Value("${config.info}")//config.info是配置中心中yml中定义的
    private String configInfo;


    @GetMapping(value = "/nacos/config")
    public String getConfig(){
        return configInfo;
    }
}
