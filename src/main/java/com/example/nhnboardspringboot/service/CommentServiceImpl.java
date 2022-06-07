package com.example.nhnboardspringboot.service;

import com.example.nhnboardspringboot.domain.comment.CommentItem;
import com.example.nhnboardspringboot.domain.comment.CommentNewRequest;
import com.example.nhnboardspringboot.repository.CommentRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentItem> getCommentsInPost(Long postNo) {
        // return commentRepository.findAll(postNo);
        return null;
    }

    @Override
    public void newComment(CommentNewRequest commentRequest, HttpServletRequest request) {
        // commentRepository.save(commentRequest, request);
    }

    @Override
    public CommentItem getComment(Long commentNo, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        // CommentItem commentItem = commentRepository.findById(commentNo, session);
        //
        // if(Objects.isNull(session)){
        //     return null;
        // }
        //
        // String userName = (String) session.getAttribute("username");
        //
        // if(!Objects.equals(userName, commentItem.getAuthor())){
        //     if(Objects.equals(userName, "admin")){
        //         return commentItem;
        //     }
        //     return null;
        // }
        //
        // return commentItem;

        return null;
    }

    @Override
    public void editComment(CommentNewRequest commentRequest) {
        // commentRepository.modifyComment(commentRequest);
    }
}
