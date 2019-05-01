package com.healthpartners.devdays.weborchestrator.controller;

import com.healthpartners.devdays.weborchestrator.service.ContentServiceRestService;
import com.healthpartners.devdays.weborchestrator.service.CrossServiceRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class WebOrchestrationController {

    private final CrossServiceRestService crossServiceRestService;
    private final ContentServiceRestService contentServiceRestService;

    @Autowired
    public WebOrchestrationController(CrossServiceRestService crossServiceRestService, ContentServiceRestService contentServiceRestService) {
        this.crossServiceRestService = crossServiceRestService;
        this.contentServiceRestService = contentServiceRestService;
    }

    @GetMapping("cross")
    public List<String> getAllCommentedContent() {
        return crossServiceRestService.getAllCommentedContent();
    }

    @GetMapping("cross/{id}")
    public String getCommentedContentForContentId(@PathVariable("id") Long contentId) {
        return crossServiceRestService.getCommentedContentForContentId(contentId);
    }

    @GetMapping("content")
    public String getContentForValue(@RequestParam("search") String search) {
        return contentServiceRestService.getContentForValue(search);
    }
}
