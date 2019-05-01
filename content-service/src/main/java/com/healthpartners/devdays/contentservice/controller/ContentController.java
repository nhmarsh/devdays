package com.healthpartners.devdays.contentservice.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final String content = "Dank dev days content";

    @GetMapping
    public String getContentForValue(@RequestParam(value = "suffix", required = false) String suffix) {
        if(StringUtils.isEmpty(suffix)) {
           return content;
        } else {
            return content + " for " + suffix;
        }
    }
}
