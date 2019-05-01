package com.healthpartners.devdays.dbservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Long id;
    private String comment;
}
