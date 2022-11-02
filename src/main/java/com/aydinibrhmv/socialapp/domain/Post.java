package com.aydinibrhmv.socialapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private Long userId;
    @Column(columnDefinition = "text")
    @Lob
    private String post;
}
