package com.example.nhnboardspringboot.entity.post;

import com.example.nhnboardspringboot.entity.comment.Comment;
import com.example.nhnboardspringboot.entity.user.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Post")
public class Post {

    public Post(Long postNo, String title, String content, LocalDateTime createdAt,
                Integer postDepth, Long postGroupNo, Long postGroupSeq,
                User user) {
        this.postNo = postNo;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.postDepth = postDepth;
        this.postGroupNo = postGroupNo;
        this.postGroupSeq = postGroupSeq;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Long postNo;

    @Transient
    private String userName;

    private String title;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "post_depth")
    private Integer postDepth;

    @Column(name = "post_group_no")
    private Long postGroupNo;

    @Column(name = "post_group_seq")
    private Long postGroupSeq;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_no")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        comment.setPost(this);
        comments.add(comment);
    }

}
