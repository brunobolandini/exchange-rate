package com.au.marlo.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "microservice.rates")
public class DemoConfiguration {

    private String apiKey;

}
