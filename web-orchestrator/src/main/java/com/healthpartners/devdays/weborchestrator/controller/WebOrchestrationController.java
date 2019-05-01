package com.healthpartners.devdays.weborchestrator.controller;

import com.healthpartners.devdays.weborchestrator.service.CrossServiceRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WebOrchestrationController {

    private final CrossServiceRestService crossServiceRestService;

    @Autowired
    public WebOrchestrationController(CrossServiceRestService crossServiceRestService) {
        this.crossServiceRestService = crossServiceRestService;
    }


    @GetMapping("cross")
    public List<String> getAllCommentedContent() {
        return crossServiceRestService.getAllCommentedContent();
    }
}
