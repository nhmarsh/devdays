package com.healthpartners.devdays.weborchestrator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class ContentServiceRestService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8090/content/";

    public String getContentForValue(@RequestParam("search") String search) {
        String result = restTemplate.getForObject(baseContentServiceUrl, String.class);

        // TODO?
        return result;
    }
}
