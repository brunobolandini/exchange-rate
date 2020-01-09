package com.marlo.demo.api.controller;

import com.marlo.demo.api.model.RateRequest;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface RateOperations {

    ResponseEntity rates();

    ResponseEntity saveRates(@NonNull RateRequest rateRequest);
}
