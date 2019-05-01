package com.healthpartners.devdays.dbservice.dto.mapper;

import com.healthpartners.devdays.dbservice.dto.CommentDto;
import com.healthpartners.devdays.dbservice.entity.Comment;

public class CommentDtoMapper {

    public static Comment toEntity(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .value(commentDto.getComment())
                .build();
    }

    public static CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .comment(comment.getValue())
                .id(comment.getId())
                .build();
    }
}
