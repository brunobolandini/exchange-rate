package com.marlo.demo.service;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.mapper.RateDetailsMapper;
import com.marlo.demo.persistence.domain.RateDetailsEntity;
import com.marlo.demo.persistence.repository.DemoRepository;
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

    /***
     * Insert fetched rate in the data repository
     *
     * @param rateRequest requested rate details
     * @return success message.
     */
    public RateResponse saveRates(RateRequest rateRequest) {
        RateDetailsEntity rateDetailsEntity = rateDetailsMapper.rateDetailsEntityMapping(rateRequest);
        try {
            demoRepository.save(rateDetailsEntity);
            return RateResponse.builder()
                               .success("true")
                               .build();
        } catch (Exception e) {
            log.error("Exception when persisting rates details: {}", e.getMessage());
        }
        return RateResponse.builder()
                           .success("false")
                           .build();
    }

}
