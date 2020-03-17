package com.ws.springcloud.controller;

import com.ws.springcloud.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/17
 * DESC：
 **/
@RestController
public class MessageController {
    @Autowired
    private SendMessage sendMessage;

    @GetMapping(value = "/stream/send")
    public String sendMessage(){
        return sendMessage.send();
    }
}
