package com.ws.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/15
 * DESC：
 **/
@RestController
@RefreshScope//动态刷新获取github上值的改变
public class ConfigClientController {
    /**config.info 是github中yml 文件配置的名称**/
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/configInfo")
    public String getConfig(){
        return configInfo;
    }
}
