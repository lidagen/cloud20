package com.ws.springcloud.exc;

/**
 * USER: wang_s
 * DATE：2020/3/9
 * DESC：
 **/
public class AppException extends RuntimeException {
    private int code;

    private String message;

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(String message) {
        super(message);
    }
}
