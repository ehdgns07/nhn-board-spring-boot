package com.example.nhnboardspringboot.service;

import com.example.nhnboardspringboot.domain.post.PostDetailViewDto;
import com.example.nhnboardspringboot.domain.post.PostNewRequest;
import com.example.nhnboardspringboot.domain.post.PostsDto;
import com.example.nhnboardspringboot.entity.post.Post;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PageImpl<PostsDto> getPagingPosts(Pageable pageable);

    PostDetailViewDto getPost(Long postNo);

    void newPost(PostNewRequest postRequest, HttpServletRequest request);

    void doReplyPost(PostNewRequest postRequest, HttpServletRequest request);

    Post editPost(PostNewRequest postEditRequest);
}
