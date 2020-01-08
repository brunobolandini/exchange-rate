package com.marlo.demo.mapper;

import java.math.BigDecimal;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.api.model.RateValue;
import com.marlo.demo.persistence.domain.RateDetailsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RateDetailsMapperTest {

    @InjectMocks
    RateDetailsMapper rateDetailsMapper;

    @Test
    public void rateDetailsEntityMappingTest() {
        RateDetailsEntity rateDetailsEntity = rateDetailsMapper.rateDetailsEntityMapping(createRequest());
       assertThat(rateDetailsEntity).isNotNull();
        assertThat(rateDetailsEntity.getSuccess()).isEqualTo("true");
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
