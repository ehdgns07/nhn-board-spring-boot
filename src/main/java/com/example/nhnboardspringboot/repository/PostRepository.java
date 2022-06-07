package com.example.nhnboardspringboot.repository;

import com.example.nhnboardspringboot.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends PostRepositoryCustom, JpaRepository<Post, Long> {

    Page<Post> getAllBy(Pageable pageable);

    // List<Post> getAllBy();
}
