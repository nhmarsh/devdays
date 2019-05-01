package com.healthpartners.devdays.weborchestrator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContentServiceRestService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8090/content/";

    public String getContentForValue(String suffix) {
        String result = restTemplate.getForObject(baseContentServiceUrl + suffix, String.class);

        // TODO?
        return result;
    }
}
