package com.healthpartners.devdays.weborchestrator.service;

import com.healthpartners.devdays.weborchestrator.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Autowired
public class CommentService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseContentServiceUrl = "http://localhost:8080/comment/";

    public List<CommentDto> getComments() {
        return restTemplate.getForObject(baseContentServiceUrl, ArrayList.class);
    }

    public CommentDto getCommentById(Long id) {
        return restTemplate.getForObject(baseContentServiceUrl + id, CommentDto.class);
    }

    public CommentDto postComment(CommentDto commentDto) {
        
    }

}
