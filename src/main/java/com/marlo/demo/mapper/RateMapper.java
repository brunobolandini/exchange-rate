package com.marlo.demo.mapper;

import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.api.model.RateValue;
import com.marlo.demo.client.model.RateData;
import org.springframework.stereotype.Component;

@Component
public class RateMapper {

    /**
     * Mapping rate data object from external API to response object
     * @param rateData rates fetched from PI
     * @return Rate response object
     */
    public RateResponse commonRateMapping(RateData rateData) {
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
