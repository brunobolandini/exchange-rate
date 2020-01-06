package com.au.marlo.demo.mapper;

import com.au.marlo.demo.api.model.RateResponse;
import com.au.marlo.demo.api.model.RateValue;
import com.au.marlo.demo.client.model.RateData;
import org.springframework.stereotype.Component;

@Component
public class RateMapper {

    public RateResponse commonUserMapping(RateData rateData) {
        return RateResponse.builder()
                           .success(rateData.getSuccess())
                           .timestamp(rateData.getTimestamp())
                           .base(rateData.getBase())
                           .date(rateData.getDate())
                           .rates(RateValue.builder()
                                           .australianDolar(rateData.getRates().get("AUD"))
                                           .brazilianReal(rateData.getRates().get("BRL"))
                                           .build())
                           .build();

    }

}
