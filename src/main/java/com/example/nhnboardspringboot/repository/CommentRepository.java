package com.example.nhnboardspringboot.repository;

import com.example.nhnboardspringboot.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
