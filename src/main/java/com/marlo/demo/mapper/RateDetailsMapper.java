package com.marlo.demo.mapper;

import java.time.LocalDateTime;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.persistence.domain.RateDetailsEntity;
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
