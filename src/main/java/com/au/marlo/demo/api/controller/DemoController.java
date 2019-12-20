package com.au.marlo.demo.api.controller;

import com.au.marlo.demo.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements DemoOperations{

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    @GetMapping(path = "/rates")
    public ResponseEntity user() {
        return ResponseEntity.ok(demoService.user());
    }
}
