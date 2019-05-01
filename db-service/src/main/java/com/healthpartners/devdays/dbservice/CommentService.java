package com.healthpartners.devdays.dbservice;

import com.healthpartners.devdays.dbservice.dao.CommentDao;
import com.healthpartners.devdays.dbservice.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> getComments() {
        System.out.println("Invoking getComments");
        return commentDao.findAll();
    }

    public Comment getCommentById(Long commentId) {
        System.out.println("Invoking getCommentById");
        return commentDao.getOne(commentId);
    }

    public Comment createOrSave(Comment comment) {
        System.out.println("Invoking createOrSave");
        return commentDao.save(comment);
    }
}
