package com.example.nhnboardspringboot.controller;

import com.example.nhnboardspringboot.domain.comment.CommentNewRequest;
import com.example.nhnboardspringboot.service.CommentService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/new")
    public String doNewComment(@ModelAttribute CommentNewRequest commentRequest,
                               HttpServletRequest request) {

        commentService.newComment(commentRequest, request);

        return "redirect:/posts";
    }

    @GetMapping("/edit/{commentNo}")
    public ModelAndView doEditComment(@PathVariable Long commentNo, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("comments/edit");
        mav.addObject("comment", commentService.getComment(commentNo,request));
        mav.addObject("comment", commentService.getComment(commentNo, request));
        commentService.getComment(commentNo, request);
        return mav;
    }

    @PostMapping("/edit")
    public String doEditComment(@ModelAttribute CommentNewRequest commentRequest){

        commentService.editComment(commentRequest);

        return "redirect:/posts/" + commentRequest.getPostNo();
    }
}
