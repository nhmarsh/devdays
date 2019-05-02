package com.healthpartners.devdays.weborchestrator.service;

import com.healthpartners.devdays.weborchestrator.dto.CommentDto;
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


    @HystrixCommand(fallbackMethod = "fallbackGetComments")
    public List<CommentDto> getComments() {
        System.out.println("Attempting getComments");
        List<CommentDto> result = restTemplate.getForObject(baseContentServiceUrl, ArrayList.class);
        return result;
    }

    public CommentDto getCommentById(Long id) {
        return restTemplate.getForObject(baseContentServiceUrl + id, CommentDto.class);
    }

    public CommentDto postComment(CommentDto commentDto) {
        return restTemplate.postForObject(baseContentServiceUrl, commentDto, CommentDto.class);
    }

    public List<CommentDto> fallbackGetComments() {
        System.out.println("Falling back on getComments");
        return Arrays.asList(CommentDto.builder().comment("Comment service is down right now!").build());
    }

}