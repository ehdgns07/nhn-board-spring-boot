package com.example.nhnboardspringboot.domain.comment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentNewRequest {
    private Long userNo;
    private Long postNo;
    private String content;
    private LocalDateTime createdAt;
}
