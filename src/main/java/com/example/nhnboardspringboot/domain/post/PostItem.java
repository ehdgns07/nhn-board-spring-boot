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
public class PostItem {
    private Long postNo;
    private String title;
    private String username;
    private String author;
    private String modifier;
    private LocalDateTime createdAt;
    // private Integer replyCount;
}
