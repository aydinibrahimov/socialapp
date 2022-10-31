package com.aydinibrhmv.socialapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="like")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;

}
