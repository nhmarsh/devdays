package com.healthpartners.devdays.weborchestrator.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CrossServiceRestService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseCrossServiceUrl = "http://localhost:8100/combine/";

    @HystrixCommand(fallbackMethod = "fallbackGetAllCommentedContent")
    public List<String> getAllCommentedContent() {
        List<String> results = restTemplate.getForObject(baseCrossServiceUrl, ArrayList.class);

        //TODO
        return results;
    }

    public String getCommentedContentForContentId(Long contentId) {
        //TODO netflix error handling stuff
        String result = restTemplate.getForObject(baseCrossServiceUrl + contentId, String.class);

        return result;
    }

    public List<String> fallbackGetAllCommentedContent() {
        return Arrays.asList("Cross service is down right now! Please try again later");
    }

}
