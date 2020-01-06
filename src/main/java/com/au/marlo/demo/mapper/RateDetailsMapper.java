package com.au.marlo.demo.mapper;

import java.time.LocalDateTime;

import com.au.marlo.demo.api.model.RateRequest;
import com.au.marlo.demo.persistence.domain.RateDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class RateDetailsMapper {

    public RateDetailsEntity rateDetailsEntityMapping(RateRequest rateRequest) {
        RateDetailsEntity rateDetailsEntity = new RateDetailsEntity();
        rateDetailsEntity.setSuccess(rateRequest.getSuccess());
        rateDetailsEntity.setBase(rateRequest.getBase());
        rateDetailsEntity.setDate(rateRequest.getDate());
        rateDetailsEntity.setTimestamp(LocalDateTime.now());
        rateDetailsEntity.setUpdatedOn(LocalDateTime.now());
        return rateDetailsEntity;
    }

}
