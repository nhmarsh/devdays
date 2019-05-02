package com.healthpartners.devdays.weborchestrator.controller;

import com.healthpartners.devdays.weborchestrator.dto.CommentDto;
import com.healthpartners.devdays.weborchestrator.service.CommentServiceRestService;
import com.healthpartners.devdays.weborchestrator.service.ContentServiceRestService;
import com.healthpartners.devdays.weborchestrator.service.CrossServiceRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class WebOrchestrationController {

    private final CrossServiceRestService crossServiceRestService;
    private final ContentServiceRestService contentServiceRestService;
    private final CommentServiceRestService commentServiceRestService;

    @Autowired
    public WebOrchestrationController(CrossServiceRestService crossServiceRestService, ContentServiceRestService contentServiceRestService, CommentServiceRestService commentServiceRestService) {
        this.crossServiceRestService = crossServiceRestService;
        this.contentServiceRestService = contentServiceRestService;
        this.commentServiceRestService = commentServiceRestService;
    }

    @GetMapping("cross")
    public ResponseEntity<List<String>> getAllCommentedContent() {
        return ResponseEntity.ok(crossServiceRestService.getAllCommentedContent());
    }

    @GetMapping("cross/{id}")
    public ResponseEntity<String> getCommentedContentForContentId(@PathVariable("id") Long contentId) {
        return ResponseEntity.ok(crossServiceRestService.getCommentedContentForContentId(contentId));
    }

    @GetMapping("content")
    public String getContentForValue(@RequestParam(value = "suffix", required=false) String suffix) {
        return contentServiceRestService.getContentForValue(suffix);
    }

    @GetMapping("comment")
    public List<CommentDto> getComments() {
        return commentServiceRestService.getComments();
    }

    @GetMapping("comment/{commentId}")
    public CommentDto getCommentById(@PathVariable("commentId") Long commentId) {
        return commentServiceRestService.getCommentById(commentId);
    }

    @PostMapping("comment")
    public CommentDto createNewComment(@RequestBody CommentDto commentDto) {
        return commentServiceRestService.postComment(commentDto);
    }
}
