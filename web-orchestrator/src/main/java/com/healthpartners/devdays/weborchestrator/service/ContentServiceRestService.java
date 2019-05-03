package com.healthpartners.devdays.weborchestrator.service;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ContentServiceRestService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8090/content/";

    @HystrixCommand(commandKey = "getContent", fallbackMethod = "fallbackGetContentForValue")
    public String getContentForValue(String suffix) {
        URI uri = UriComponentsBuilder.fromUriString(baseContentServiceUrl)
                .queryParam("suffix", suffix)
                .build().toUri();
        String result = restTemplate.getForObject(uri, String.class);

        // TODO?
        return result;
    }

    public String fallbackGetContentForValue(String suffix) {
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("getContent"));
        if(breaker.isOpen()) {
            throw new RuntimeException("Down stop trying");
        }
        return "Oops, try again!";
    }
}
