package com.example.nhnboardspringboot.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailViewDto {
    Long postNo;
    String title;
    String username;
    String content;

}
