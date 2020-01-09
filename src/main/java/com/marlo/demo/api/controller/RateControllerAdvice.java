package com.marlo.demo.api.controller;

import com.marlo.demo.exception.MethodNotImplementedException;
import com.marlo.demo.exception.InvalidBodyException;
import com.marlo.demo.api.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RateControllerAdvice
    extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported (HttpRequestMethodNotSupportedException ex,
                                                                            HttpHeaders headers, HttpStatus status, WebRequest request){
        return new ResponseEntity<>(new ApiError(new MethodNotImplementedException("Only available methods are gets and posts.").getMessage(),"0001"), HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ApiError(new InvalidBodyException("Invalid request body").getMessage(),"000034"), HttpStatus.BAD_REQUEST);
    }

}
