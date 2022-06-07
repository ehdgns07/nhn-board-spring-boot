package com.example.nhnboardspringboot.service;

import com.example.nhnboardspringboot.domain.comment.CommentItem;
import com.example.nhnboardspringboot.domain.comment.CommentNewRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface CommentService {
    List<CommentItem> getCommentsInPost(Long postNo);

    void newComment(CommentNewRequest commentRequest, HttpServletRequest request);

    CommentItem getComment(Long commentNo, HttpServletRequest request);

    void editComment(CommentNewRequest commentRequest);
}
