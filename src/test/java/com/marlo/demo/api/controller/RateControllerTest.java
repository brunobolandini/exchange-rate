package com.marlo.demo.api.controller;

import java.math.BigDecimal;
import java.util.Objects;

import com.marlo.demo.api.model.RateRequest;
import com.marlo.demo.api.model.RateResponse;
import com.marlo.demo.api.model.RateValue;
import com.marlo.demo.client.RateClient;
import com.marlo.demo.service.GetRatesService;
import com.marlo.demo.service.SaveRatesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class RateControllerTest {

    private static final String BASE_PATH = "http://localhost:%d";

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @MockBean
    GetRatesService getRatesService;

    @MockBean
    SaveRatesService saveRatesService;

    @MockBean
    RateClient rateClient;

    @Test
    public void getRatesSuccessTest() {
        RateResponse rateResponse = getResponse();
        String url = createPath("/rates");

        given(getRatesService.rate()).willReturn(rateResponse);

        ResponseEntity<RateResponse> responseEntity = restTemplate.getForEntity(url, RateResponse.class);
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getSuccess()).isEqualTo("true");
    }

    @Test
    public void saveRatesSuccessTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RateRequest rateRequest = createRequest();
        HttpEntity httpEntity = new HttpEntity<>(createRequest(), headers);
        String url = createPath("/rates");

        ResponseEntity responseEntity = restTemplate.postForEntity(url, httpEntity, Object.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    private RateRequest createRequest() {
        return RateRequest.builder()
                          .success("true")
                          .base("USD")
                          .date("01-07-2020")
                          .rates(RateValue.builder()
                                          .australianDolar(new BigDecimal("1.624655"))
                                          .brazilianReal(new BigDecimal("4.557919"))
                                          .build())
                          .timestamp("1578333006")
                          .build();

    }

    private String createPath(String operation) {
        String url = BASE_PATH + operation;
        return String.format(url, port);
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
