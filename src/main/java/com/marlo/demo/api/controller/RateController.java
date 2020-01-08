package com.marlo.demo.api.controller;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.service.GetRatesService;
import com.marlo.demo.service.SaveRatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController implements RateOperations {

    private final GetRatesService getRatesService;

    private final SaveRatesService saveRatesService;

    public RateController(GetRatesService demoService, SaveRatesService saveRatesService) {
        this.getRatesService = demoService;
        this.saveRatesService = saveRatesService;
    }

    @Override
    @GetMapping(path = "/rates")
    public ResponseEntity rates() {
        return ResponseEntity.ok(getRatesService.rate());
    }

    @Override
    @PostMapping(path = "/rates")
    public ResponseEntity saveRates(@RequestBody RateRequest rateRequest) {
        saveRatesService.saveRates(rateRequest);
        return ResponseEntity.noContent()
                             .build();
    }


}
