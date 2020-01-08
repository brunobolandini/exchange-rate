package com.au.marlo.demo.client;

import com.au.marlo.demo.client.model.RateData;
import com.au.marlo.demo.configuration.DemoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateClient {

    private final RestTemplate restTemplate;
    private final DemoConfiguration demoConfiguration;

    public RateClient(RestTemplate restTemplate, DemoConfiguration demoConfiguration) {
        this.restTemplate = restTemplate;
        this.demoConfiguration = demoConfiguration;
    }

    public RateData getFixerRate() {
        HttpHeaders headers = new HttpHeaders();
        String url = urlBuilder();
        headers.add("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, RateData.class).getBody();

    }

    protected String urlBuilder() {
        return demoConfiguration.getHost() + "?access_key=" + demoConfiguration.getApiKey();
    }
}
