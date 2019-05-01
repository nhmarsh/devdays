package com.healthpartners.devdays.crossservice.service;

import com.healthpartners.devdays.crossservice.dto.CommentDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String commentServiceUrl = "http://localhost:8080/comment/";
    private final ParameterizedTypeReference<List<CommentDto>> parameterizedTypeReference = new ParameterizedTypeReference<List<CommentDto>>() {};

    public List<CommentDto> getAllComments() {
        ResponseEntity<List<CommentDto>> responseEntity = restTemplate.exchange(commentServiceUrl , HttpMethod.GET, null, parameterizedTypeReference);
        List<CommentDto> commentDtoList = responseEntity.getBody();
        return commentDtoList;
    }

    public CommentDto getCommentById(Long id) {
        String commentUrl = commentServiceUrl + id;
        //todo error handling
        CommentDto commentDto = restTemplate.getForObject(commentUrl, CommentDto.class);

        return commentDto;
    }

}
