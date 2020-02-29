package com.hhh.apigateway.exception;

/**
 * @author hhh
 * @date 2020/2/29 10:13
 * @description
 */
public class RateLimitException extends RuntimeException {
    public RateLimitException() {
        super();
    }

    public RateLimitException(String message) {
        super(message);
    }
}
