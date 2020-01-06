package com.au.marlo.demo.service;

import com.au.marlo.demo.api.model.RateRequest;
import com.au.marlo.demo.mapper.RateDetailsMapper;
import com.au.marlo.demo.persistence.domain.RateDetailsEntity;
import com.au.marlo.demo.persistence.repository.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SaveRatesService {

    private final Logger log = LoggerFactory.getLogger(SaveRatesService.class);

    private final DemoRepository demoRepository;

    private final RateDetailsMapper rateDetailsMapper;

    public SaveRatesService(DemoRepository demoRepository, RateDetailsMapper rateDetailsMapper) {
        this.demoRepository = demoRepository;
        this.rateDetailsMapper = rateDetailsMapper;
    }

    public void saveRates(RateRequest rateRequest) {
        RateDetailsEntity rateDetailsEntity = rateDetailsMapper.rateDetailsEntityMapping(rateRequest);
        try {
            demoRepository.save(rateDetailsEntity);
        } catch (Exception e) {
            log.error("Exception when persisting rates details: {}", e.getMessage());
        }
    }

}
