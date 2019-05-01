package com.healthpartners.devdays.weborchestrator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ContentServiceRestService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8090/content/";

    public String getContentForValue(String suffix) {
        URI uri = UriComponentsBuilder.fromUriString(baseContentServiceUrl)
                .queryParam("suffix", suffix)
                .build().toUri();
        String result = restTemplate.getForObject(uri, String.class);

        // TODO?
        return result;
    }
}
