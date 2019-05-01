package com.healthpartners.devdays.crossservice.controller;

import com.healthpartners.devdays.crossservice.dto.CommentDto;
import com.healthpartners.devdays.crossservice.service.CommentService;
import com.healthpartners.devdays.crossservice.service.ContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/combine")
public class CrossServiceController {

    private final ContentService contentService;
    private final CommentService commentService;

    public CrossServiceController(ContentService contentService, CommentService commentService) {
        this.contentService = contentService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<String> getContentForAllComments() {
        List<CommentDto> commentDtoList = commentService.getAllComments();

        return commentDtoList.stream().map(commentDto -> contentService.getContentForComment(commentDto.getComment())).collect(Collectors.toList());
    }

    @GetMapping("/{contentId}")
    public String getContentForStoredComment(@PathVariable("contentId") Long contentId) {
        CommentDto commentDto = commentService.getCommentById(contentId);

        return contentService.getContentForComment(commentDto.getComment());
    }
}
