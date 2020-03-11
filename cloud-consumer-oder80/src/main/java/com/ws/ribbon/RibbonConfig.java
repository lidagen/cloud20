package com.ws.ribbon;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * USER: wang_s
 * DATE：2020/3/11
 * DESC：
 **/
@Configuration
public class RibbonConfig {
    @Bean
    public IRule getRule(){
        return new AvailabilityFilteringRule();
    }
}
