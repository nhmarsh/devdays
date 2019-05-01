package com.healthpartners.devdays.crossservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ContentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String contentServiceUrl = "http://localhost:8090/content";
    public ContentService() {

    }

    public String getContentForComment(String comment) {
        String url = contentServiceUrl + "?suffix=" + comment;

        return restTemplate.getForObject(url, String.class);
    }

}
