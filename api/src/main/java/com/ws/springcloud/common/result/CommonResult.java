package com.ws.springcloud.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * USER: wang_s
 * DATE：2020/3/8
 * DESC： 通用返回类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

    public CommonResult(T data) {
        this(200,"success",data);
    }
}
