package com.au.marlo.demo.client;

import com.au.marlo.demo.client.model.RateData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateClient {

    private final String URL = "http://data.fixer.io/api/latest";
    private final String accessKey = "3337f4212c047f9522c4f2a7fcbe3c5c";
    private final RestTemplate restTemplate;

    public RateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RateData getRate() {
        HttpHeaders headers = new HttpHeaders();
        String url = urlBuilder(URL, accessKey);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, RateData.class).getBody();

    }

    private String urlBuilder(String url, String accessKey) {
        return url + "?access_key=" + accessKey;
    }
}
