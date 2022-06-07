package com.example.nhnboardspringboot.repository;

import com.example.nhnboardspringboot.domain.post.PostDetailViewDto;
import com.example.nhnboardspringboot.domain.post.PostsDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PostRepositoryCustom {
    PageImpl<PostsDto> getPosts(Pageable pageable);

   PostDetailViewDto getPostById(Long userId);
}
