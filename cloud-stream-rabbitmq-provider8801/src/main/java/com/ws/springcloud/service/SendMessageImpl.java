package com.ws.springcloud.service;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * USER: wang_s
 * DATE：2020/3/17
 * DESC：
 **/
@Slf4j
@EnableBinding(Source.class)//定义消息的推送管道
public class SendMessageImpl implements SendMessage {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = IdUtil.simpleUUID();

        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("=====>uuid:"+uuid);
        return null;
    }
}
