package com.example.nhnboardspringboot.domain.post;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class PostDetailViewDto {
    private Long postNo;
    private String title;
    private String username;
    private String content;
    private Long postGroupSeq;
    private Long userNo;

}
