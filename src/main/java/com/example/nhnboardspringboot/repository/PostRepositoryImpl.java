package com.example.nhnboardspringboot.repository;

import com.example.nhnboardspringboot.domain.post.PostDetailViewDto;
import com.example.nhnboardspringboot.domain.post.PostsDto;
import com.example.nhnboardspringboot.entity.post.Post;
import com.example.nhnboardspringboot.entity.post.QPost;
import com.example.nhnboardspringboot.entity.user.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Post.class);
    }

    @Override

    public PageImpl<PostsDto> getPosts(Pageable pageable) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        JPQLQuery<PostsDto> query = from(post)
                                       .innerJoin(post.user, user)
                                       .where(post.postNo.gt(0))
                                       .orderBy(post.postNo.desc())
                                       .orderBy(post.createdAt.desc())
                                       .select(Projections.bean(PostsDto.class, post.postNo, post.title,
                                            post.content, post.createdAt, post.postDepth,
                                            post.postGroupNo, post.postGroupSeq));

         Long totalCount = query.fetchCount();
         List<PostsDto> resultCount = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(resultCount, pageable, totalCount);

    }

    @Override
    public List<PostDetailViewDto> getPostById(Long postNo) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        return from(post)
            .innerJoin(post.user, user)
            .where(post.postNo.eq(postNo))
            .select(Projections.bean(PostDetailViewDto.class, post.postNo, post.title,
                user.username, post.content))
            .fetch();

    }


}
