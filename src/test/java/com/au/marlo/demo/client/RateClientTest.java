package com.au.marlo.demo.client;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.au.marlo.demo.client.model.RateData;
import com.au.marlo.demo.configuration.DemoConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RateClientTest {

    @Spy
    @InjectMocks
    RateClient rateClient;

    @Mock
    RestTemplate restTemplate;

    @Mock
    DemoConfiguration demoConfiguration;

    @Before
    public void setUp() {
        given(demoConfiguration.getApiKey()).willReturn("blablablabla");
        given(demoConfiguration.getHost()).willReturn("http://data.fixer.io/api/latest");
    }

    @Test
    public void getFixerRateTest() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity<>(httpHeaders);

        String url = demoConfiguration.getHost() + "?access_key=" + demoConfiguration.getApiKey();
        RateData rateDataResponse = createRateData();

        given(restTemplate.exchange(url,
                                    HttpMethod.GET,
                                    entity,
                                    RateData.class))
                .willReturn(ResponseEntity.ok(rateDataResponse));

        RateData rateData = restTemplate.exchange(url, HttpMethod.GET, entity, RateData.class).getBody();
        assertThat(rateData).isNotNull();
    }

    @Test
    public void urlBuilderTest() {
        String url = rateClient.urlBuilder();
        String assertUrl = demoConfiguration.getHost() + "?access_key=" + demoConfiguration.getApiKey();
        assertThat(url).isNotNull();
        assertThat(url).isEqualTo(assertUrl);
    }


    private RateData createRateData() {
        RateData rateData = new RateData();
        rateData.setSuccess("true");
        rateData.setTimestamp("1578444006");
        rateData.setBase("USD");
        rateData.setDate("07-01-2020");

        Map<String, BigDecimal> rates = new HashMap<>();
        rates.put("AUD", new BigDecimal("1.613674"));
        rates.put("BRL", new BigDecimal("4.550242"));
        rateData.setRates(rates);
        return rateData;
    }
}
