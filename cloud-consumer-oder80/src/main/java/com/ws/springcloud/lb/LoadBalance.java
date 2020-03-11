package com.ws.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    /**
     * 从Eureka中所有的ServiceInstanceList 挑选符合负载均衡的ServiceInstance
     * @param serviceInstances
     * @return
     */
    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
