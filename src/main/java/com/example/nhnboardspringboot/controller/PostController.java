package com.example.nhnboardspringboot.controller;

import com.example.nhnboardspringboot.domain.post.PostDetailViewDto;
import com.example.nhnboardspringboot.domain.post.PostNewRequest;
import com.example.nhnboardspringboot.domain.post.PostsDto;
import com.example.nhnboardspringboot.service.CommentService;
import com.example.nhnboardspringboot.service.PostService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/index")
    public String index(Pageable pageable, Model model) {

        Page<PostsDto> pagedPost = postService.getPagingPosts(pageable);
        model.addAttribute("posts", pagedPost);

        return "posts/index";
    }

    @GetMapping("/{postNo}")
    public String postDetail(@PathVariable Long postNo, Model model) {
        model.addAttribute("post", postService.getPost(postNo));

        return "posts/post";
    }

    @GetMapping("/new")
    public String newPost() {
        return "posts/new";
    }

    @PostMapping("/new")
    public String doNewPost(@RequestBody PostNewRequest postRequest, HttpServletRequest request) {

        postService.newPost(postRequest, request);

        return "redirect:/posts";
    }

    @GetMapping("/{postNo}/edit")
    public ModelAndView editPost(@PathVariable Long postNo) {
        ModelAndView mav = new ModelAndView("posts/edit");
        mav.addObject("postNo", postNo);
        mav.addObject("post", postService.getPost(postNo));

        return mav;
    }

    @PutMapping("/{postNo}/edit")
    public ModelAndView doEditPost(@RequestParam("title")String title, @RequestParam("content")String content) {
        // TODO: Validation -> index | postDetail
        ModelAndView mav = new ModelAndView("posts/post");
        // mav.addObject("post", postService.editPost(title, content));
        // return "posts/edit";
        return null;
    }

    @PostMapping("/{postNo}/edit")
    public ModelAndView doEditPost(@ModelAttribute PostNewRequest postEditRequest) {
        // TODO: Validation -> index | postDetail
        ModelAndView mav = new ModelAndView("posts/index");
        mav.addObject("post", postService.editPost(postEditRequest));
        // return "posts/edit";
        return mav;
    }

    @GetMapping("/delete")
    public String deletePost() {
        return "posts/delete";
    }

    @DeleteMapping("/delete")
    public String doDeletePost() {
        return null;
    }

    @GetMapping("/reply/{postNo}")
    public ModelAndView reply(@PathVariable Long postNo) {
        ModelAndView mav = new ModelAndView("posts/reply");
        mav.addObject("postNo", postNo);

        return mav;
    }

    @PostMapping("/reply/{parentPostNo}")
    public String doReply(@ModelAttribute PostNewRequest postRequest, HttpServletRequest request) {
        postService.doReplyPost(postRequest, request);

        return "redirect:/posts";
    }
}
