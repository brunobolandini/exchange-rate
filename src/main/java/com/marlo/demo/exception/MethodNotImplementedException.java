package com.marlo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class MethodNotImplementedException extends RuntimeException {
    public MethodNotImplementedException(String message) {
        super(message);
    }
}
