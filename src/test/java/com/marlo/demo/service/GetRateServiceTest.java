package com.marlo.demo.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.api.model.RateValue;
import com.marlo.demo.client.RateClient;
import com.marlo.demo.client.model.RateData;
import com.marlo.demo.mapper.RateMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GetRateServiceTest {

    @InjectMocks
    private GetRatesService getRatesService;

    @Mock
    private RateClient rateClient;

    @Mock
    private RateMapper rateMapper;

    @Test
    public void getRateSuccessTest() {
        RateData rateData = createRateData();
        given(rateClient.getFixerRate()).willReturn(rateData);
        given(rateMapper.commonRateMapping(rateData)).willReturn(getResponse());
        given(getRatesService.rate()).willReturn(getResponse());

        RateResponse rateResponse = getRatesService.rate();
        assertThat(rateResponse).isNotNull();
    }

    @Test
    public void getRateFailTest() {
        given(rateClient.getFixerRate()).willReturn(null);
        given(getRatesService.rate()).willReturn(null);

        RateResponse rateResponse = getRatesService.rate();
        assertThat(rateResponse).isNull();
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

    private RateResponse getResponse() {
        return RateResponse.builder()
                           .success("true")
                           .base("EUR")
                           .date("01-07-2020")
                           .rates(RateValue.builder()
                                           .australianDolar(new BigDecimal("1.613674"))
                                           .brazilianReal(new BigDecimal("4.550242"))
                                           .build())
                           .timestamp("1578444006")
                           .build();
    }
}
