package com.ws.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * USER: wang_s
 * DATE：2020/3/14
 * DESC：GATEWAY 网关配置  取代yml
 **/
//@Configuration
public class GatewayConfig {
/*
    @Bean
    public RouteLocator getRoute(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("payment_touth1",r->r.path("/payment/**")
                .uri("http://localhost:8001")).build();

*//*
        routes.route("payment_touth3",r->r.path("/payment/**")
                .uri("http://localhost:8003")).build();*//*


        return routes.build();
    }*/
}
