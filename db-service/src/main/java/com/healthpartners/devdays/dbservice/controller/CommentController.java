package com.healthpartners.devdays.dbservice.controller;

import com.healthpartners.devdays.dbservice.dao.CommentDao;
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
    public ResponseEntity<List<Comment>> getComments() {
        //TODO error handling here
        List<Comment> result = commentDao.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getById(@PathVariable("commentId") Long commentId) {
        Comment commentForId = commentDao.getOne(commentId);

        if(commentForId == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(commentForId);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment result = commentDao.saveAndFlush(comment);
        return ResponseEntity.ok(result);
    }
}
