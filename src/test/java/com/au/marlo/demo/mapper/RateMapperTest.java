package com.au.marlo.demo.mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.au.marlo.demo.api.model.RateResponse;
import com.au.marlo.demo.client.model.RateData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RateMapperTest {

    @InjectMocks
    RateMapper rateMapper;

    @Test
    public void commonRateMappingTest() {
        RateResponse rateResponse = rateMapper.commonRateMapping(createRateData());
        assertThat(rateResponse).isNotNull();
        assertThat(rateResponse.getSuccess()).isEqualTo("true");
        assertThat(rateResponse.getBase()).isEqualTo("USD");
    }

    private RateData createRateData() {
        RateData rateData = new RateData();
        rateData.setSuccess("true");
        rateData.setDate("07-01-2020");
        rateData.setBase("USD");

        Map<String, BigDecimal> rates = new HashMap<>();
        rates.put("AUD", new BigDecimal("1.613674"));
        rates.put("BRL", new BigDecimal("4.550242"));
        rateData.setRates(rates);
        rateData.setTimestamp("1578444006");
        return rateData;
    }
}
