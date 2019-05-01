package com.healthpartners.devdays.dbservice.dao;

import com.healthpartners.devdays.dbservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
}
