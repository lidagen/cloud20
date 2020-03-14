package com.ws.springcloud.filter;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * USER: wang_s
 * DATE：2020/3/14
 * DESC： gateway全局日志配置Filter
 **/
@Slf4j
@Component
@Order(0)
public class GlobalLogFilter implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********GlobalLogFilter:********"+ DateUtil.now());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (null == username){
            log.error("********非法用户！********");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           // return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


}
