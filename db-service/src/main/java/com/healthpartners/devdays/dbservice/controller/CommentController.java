package com.healthpartners.devdays.dbservice.controller;

import com.healthpartners.devdays.dbservice.dao.CommentDao;
import com.healthpartners.devdays.dbservice.dto.CommentDto;
import com.healthpartners.devdays.dbservice.dto.mapper.CommentDtoMapper;
import com.healthpartners.devdays.dbservice.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
@Transactional
public class CommentController {

    private final CommentDao commentDao;

    @Autowired
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments() {
        //TODO error handling here
        List<Comment> result = commentDao.findAll();
        if(result != null && !result.isEmpty()) {
            return ResponseEntity.ok(result.stream().map(CommentDtoMapper::toDto).collect(Collectors.toList()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getById(@PathVariable("commentId") Long commentId) {
        Comment commentForId = commentDao.getOne(commentId);

        if(commentForId == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(CommentDtoMapper.toDto(commentForId));
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment) {
        Comment entity = CommentDtoMapper.toEntity(comment);
        Comment result = commentDao.save(entity);
        return ResponseEntity.ok(CommentDtoMapper.toDto(result));
    }

}
