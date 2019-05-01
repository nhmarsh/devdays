package com.healthpartners.devdays.crossservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String contentServiceUrl = "http://localhost:8090/content";
    public ContentService() {

    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String getContentForComment(String comment) {
        System.out.println("Attempting the HTTP request");
        String url = contentServiceUrl + "?suffix=" + comment;

        return restTemplate.getForObject(url, String.class);
    }

    public String reliable(String comment) {
        System.out.println("Falling back");
        return "Sorry, I can't find that content for " + comment + " right now!";
    }

}
