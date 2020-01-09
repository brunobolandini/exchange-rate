package com.marlo.demo.service;

import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.client.RateClient;
import com.marlo.demo.client.model.RateData;
import com.marlo.demo.mapper.RateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetRatesService {

    private final Logger log = LoggerFactory.getLogger(GetRatesService.class);

    private final RateClient rateClient;
    private final RateMapper rateMapper;

    public GetRatesService(RateClient rateClient, RateMapper rateMapper) {
        this.rateClient = rateClient;
        this.rateMapper = rateMapper;
    }

    /**
     * Fetch rates from the API
     *
     * @return response containing exchange rates
     */
    public RateResponse rate() {

        RateData rateData = rateClient.getFixerRate();
        log.debug("Data: {}", rateData);
        if (rateData != null) {
            return rateMapper.commonRateMapping(rateData);
        }

        return null;
    }
}
