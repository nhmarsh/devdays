package com.healthpartners.devdays.weborchestrator.service;

import com.healthpartners.devdays.weborchestrator.dto.CommentDto;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceRestService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8080/comment/";


    @HystrixCommand(commandKey = "getComments", fallbackMethod = "fallbackGetComments")
    public List<CommentDto> getComments() {
        System.out.println("Attempting getComments");
        List<CommentDto> result = restTemplate.getForObject(baseContentServiceUrl, ArrayList.class);
        return result;
    }

    public CommentDto getCommentById(Long id) {
        return restTemplate.getForObject(baseContentServiceUrl + id, CommentDto.class);
    }

    @HystrixCommand(commandKey = "postComments", fallbackMethod = "postCommentFallback")
    public CommentDto postComment(CommentDto commentDto) {
        return restTemplate.postForObject(baseContentServiceUrl, commentDto, CommentDto.class);
    }

    public List<CommentDto> fallbackGetComments() {
        System.out.println("Falling back on getComments");
        checkCircuitBreaker();
        return Arrays.asList(CommentDto.builder().comment("Oops, that didn't work. Please try again!").build());
    }

    public CommentDto postCommentFallback(CommentDto commentDto) {
        System.out.println("Falling back on postComments!");
        checkCircuitBreaker();
        return CommentDto.builder().comment("Oops, that didn't work. Please try again!").build();
    }

    public void checkCircuitBreaker() {
        HystrixCircuitBreaker breaker1 = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("getComments"));
        HystrixCircuitBreaker breaker2 = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("postComments"));
        if(breaker1.isOpen() || breaker2.isOpen()) {
            throw new RuntimeException("Down stop trying");
        }
    }

}