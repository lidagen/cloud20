package com.ws.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * USER: wang_s
 * DATE：2020/3/22
 * DESC：
 **/
@RestController
public class NacosOrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/order/{name}")
    public String getPayment(@PathVariable("name") String name){
        String forObject = restTemplate.getForObject(serverURL + "/echo/" + name, String.class);
        return forObject;
    }
}
