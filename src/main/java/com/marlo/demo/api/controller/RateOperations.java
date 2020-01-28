package com.marlo.demo.api.controller;

import javax.validation.constraints.Pattern;

import com.marlo.demo.api.model.RateRequest;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface RateOperations {

    /**
     * Fetch current exchange rates and send it in response
     * @return response containing fetched exchange rates
     */
    ResponseEntity rates();

    /**
     * Save rate details in the database
     *
     * @param rateRequest requested rate details
     * @return Rate details entity saved
     */
    ResponseEntity saveRates(@NonNull  RateRequest rateRequest);
}
