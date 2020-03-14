package com.ws.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * USER: wang_s
 * DATE：2020/3/12
 * DESC：
 **/
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
public class OrderFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix80.class,args);
    }
    /**
     * 此配置是为了服务监控bashdoard配置，与服务容错本身无关，是springcloud升级的坑
     * ServletRegistrationBean因为springboot中默认路径不是/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(0);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
