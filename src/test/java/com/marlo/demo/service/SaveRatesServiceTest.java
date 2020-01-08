package com.marlo.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.api.model.RateValue;
import com.marlo.demo.mapper.RateDetailsMapper;
import com.marlo.demo.persistence.domain.RateDetailsEntity;
import com.marlo.demo.persistence.repository.DemoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class SaveRatesServiceTest {

    @InjectMocks
    private SaveRatesService saveRatesService;

    @Mock
    private DemoRepository demoRepository;

    @Mock
    private RateDetailsMapper rateDetailsMapper;

    @Test
    public void saveRatesSuccessTest() {
        RateRequest rateRequest = createRequest();
        given(rateDetailsMapper.rateDetailsEntityMapping(rateRequest)).willReturn(createEntityDetails());

        RateResponse rateResponse = saveRatesService.saveRates(rateRequest);

        assertThat(rateResponse).isNotNull();
        assertThat(rateResponse.getSuccess()).isEqualTo("true");
    }

    @Test
    public void saveRatesFailTest() {
        RateRequest rateRequest = createRequest();
        given(rateDetailsMapper.rateDetailsEntityMapping(rateRequest)).willReturn(createEntityDetails());
        given(saveRatesService.saveRates(rateRequest)).willThrow(new RuntimeException());

        RateResponse rateResponse = saveRatesService.saveRates(rateRequest);

        assertThat(rateResponse).isNotNull();
        assertThat(rateResponse.getSuccess()).isEqualTo("false");
    }

    private RateDetailsEntity createEntityDetails() {
        RateDetailsEntity rateDetailsEntity = new RateDetailsEntity();
        rateDetailsEntity.setSuccess("true");
        rateDetailsEntity.setBase("EUR");
        rateDetailsEntity.setDate("01-07-2020");
        rateDetailsEntity.setTimestamp(LocalDateTime.now());
        return rateDetailsEntity;
    }

    private RateRequest createRequest() {
        return RateRequest.builder()
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
