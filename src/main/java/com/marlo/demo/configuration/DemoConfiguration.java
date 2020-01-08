package com.marlo.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "microservice.rates")
public class DemoConfiguration {

    private String host;
    private String apiKey;

}
