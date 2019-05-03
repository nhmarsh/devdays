package com.healthpartners.devdays.weborchestrator.service;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
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

    @HystrixCommand(commandKey = "getAllCommentedContent", fallbackMethod = "fallbackGetAllCommentedContent")
    public List<String> getAllCommentedContent() {
        List<String> results = restTemplate.getForObject(baseCrossServiceUrl, ArrayList.class);

        return results;
    }

    public String getCommentedContentForContentId(Long contentId) {
        String result = restTemplate.getForObject(baseCrossServiceUrl + contentId, String.class);

        return result;
    }

    public List<String> fallbackGetAllCommentedContent() {
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("getAllCommentedContent"));
        if(breaker != null && breaker.isOpen()) {
            return Arrays.asList("Down stop trying");
        }

        return Arrays.asList("Oops, please try again!");
    }

}
