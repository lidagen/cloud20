package com.ws.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * USER: wang_s
 * DATE：2020/3/11
 * DESC：
 **/
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger integer = new AtomicInteger(0);


    /**自旋锁 获取第几次的访问**/
    public final int getAndIncrement() {
        //当前
        int current;
        //下一个下标
        int next;
        do {
            //当前数字
            current = this.integer.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.integer.compareAndSet(current,next));
        System.out.println("***第几次访问next:***" + next);
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        //次数%服务端个数
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
