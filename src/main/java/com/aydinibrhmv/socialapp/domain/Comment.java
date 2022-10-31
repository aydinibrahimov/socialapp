package com.aydinibrhmv.socialapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;
    @Column(columnDefinition = "text")
    @Lob
    private String text;
}
