package com.example.nhnboardspringboot.domain.post;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostsDto {
    
    Long PostNo;

    String Title;

    String Content;

    LocalDateTime CreatedAt;

    Integer PostDepth;

    Long PostGroupNo;

    Long PostGroupSeq;

    String username;

    @QueryProjection
    public PostsDto(Long PostNo, String Title, String Content,
                    LocalDateTime CreatedAt, Integer PostDepth, Long PostGroupNo,
                    Long PostGroupSeq, String username) {
        this.PostNo = PostNo;
        this.Title = Title;
        this.Content = Content;
        this.CreatedAt = CreatedAt;
        this.PostDepth = PostDepth;
        this.PostGroupNo = PostGroupNo;
        this.PostGroupSeq = PostGroupSeq;
        this.username = username;

    }

    public PostsDto(){ }
}
