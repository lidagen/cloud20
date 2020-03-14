package com.ws.springcloud;

import java.time.ZonedDateTime;

/**
 * USER: wang_s
 * DATE：2020/3/14
 * DESC：
 **/
public class TimeDemo {

    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
