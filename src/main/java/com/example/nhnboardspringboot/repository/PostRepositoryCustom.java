package com.example.nhnboardspringboot.repository;

import com.example.nhnboardspringboot.domain.post.PostDetailViewDto;
import com.example.nhnboardspringboot.domain.post.PostsDto;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PostRepositoryCustom {
    PageImpl<PostsDto> getPosts(Pageable pageable);

   List<PostDetailViewDto> getPostById(Long userId);
}
