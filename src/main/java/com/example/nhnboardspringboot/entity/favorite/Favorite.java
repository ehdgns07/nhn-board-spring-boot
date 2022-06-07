package com.example.nhnboardspringboot.entity.favorite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Favorites")
public class Favorite {
    @Id
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "post_no")
    private Long postNo;


}
