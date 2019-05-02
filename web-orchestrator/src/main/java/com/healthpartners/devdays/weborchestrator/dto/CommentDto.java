package com.healthpartners.devdays.weborchestrator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Long id;
    private String comment;
}
