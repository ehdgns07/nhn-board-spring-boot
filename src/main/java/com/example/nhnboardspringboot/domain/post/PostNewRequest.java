package com.example.nhnboardspringboot.domain.post;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostNewRequest {
    private Long postNo;
    private Long userNo;
    private String userName;
    private Long parentPostNo;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Integer postDepth;
    private Long postGroupNo;
    private Long postGroupSeq;
}
