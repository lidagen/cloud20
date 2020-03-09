package com.ws.springcloud.exc;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
public class AppException extends RuntimeException {
    private int code;

    private String msg;

    public AppException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
