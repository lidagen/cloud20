package com.ws.springcloud.entites.payment;

import lombok.Data;

import java.io.Serializable;

/**
 * USER: wang_s
 * DATE：2020/3/8
 * DESC：
 **/
@Data
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
