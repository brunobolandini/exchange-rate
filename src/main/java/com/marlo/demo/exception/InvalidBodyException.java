package com.marlo.demo.exception;

public class InvalidBodyException extends RuntimeException {
    public InvalidBodyException(String msg) {
        super(msg);
    }
}
