package com.au.marlo.demo.api.controller;

import com.au.marlo.demo.api.model.RateRequest;
import org.springframework.http.ResponseEntity;

public interface DemoOperations {

    ResponseEntity rates();

    ResponseEntity saveRates(RateRequest rateRequest);
}
