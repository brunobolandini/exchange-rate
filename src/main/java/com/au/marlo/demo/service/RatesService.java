package com.au.marlo.demo.service;

import com.au.marlo.demo.api.model.RateResponse;
import com.au.marlo.demo.client.RateClient;
import com.au.marlo.demo.client.model.RateData;
import com.au.marlo.demo.mapper.RateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RatesService {

    private final Logger log = LoggerFactory.getLogger(RatesService.class);

    private final RateClient rateClient;
    private final RateMapper rateMapper;

    public RatesService(RateClient rateClient, RateMapper rateMapper) {
        this.rateClient = rateClient;
        this.rateMapper = rateMapper;
    }

    public RateResponse user() {
        RateData rateData = rateClient.getRate();
        log.debug("Data: {}", rateData);
        if (rateData != null) {
            return rateMapper.commonUserMapping(rateData);
        }

        return null;
    }
}
