package com.healthpartners.devdays.weborchestrator.controller;

import com.healthpartners.devdays.weborchestrator.dto.CommentDto;
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

    @Autowired
    public WebOrchestrationController(CrossServiceRestService crossServiceRestService, ContentServiceRestService contentServiceRestService) {
        this.crossServiceRestService = crossServiceRestService;
        this.contentServiceRestService = contentServiceRestService;
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

    @GetMapping("/comment")
    public List<CommentDto> getComments() {

    }

    @GetMapping("/comment/{commentId}")
    public CommentDto getCommentById(@PathVariable Long commentId) {

    }

    @PostMapping("/comment")
    public CommentDto createNewComment(String comment) {

    }
}
