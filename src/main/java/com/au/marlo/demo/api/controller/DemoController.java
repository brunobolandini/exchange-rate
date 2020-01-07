package com.au.marlo.demo.api.controller;

import com.au.marlo.demo.api.model.RateRequest;
import com.au.marlo.demo.service.GetRatesService;
import com.au.marlo.demo.service.SaveRatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements DemoOperations {

    private final GetRatesService getRatesService;

    private final SaveRatesService saveRatesService;

    public DemoController(GetRatesService demoService, SaveRatesService saveRatesService) {
        this.getRatesService = demoService;
        this.saveRatesService = saveRatesService;
    }

    @Override
    @GetMapping(path = "/rates")
    public ResponseEntity rates() {
        return ResponseEntity.ok(getRatesService.rate());
    }

    @Override
    @PostMapping(path = "/insert_rate")
    public ResponseEntity saveRates(@RequestBody RateRequest rateRequest) {
        saveRatesService.saveRates(rateRequest);
        return ResponseEntity.noContent()
                             .build();
    }


}
