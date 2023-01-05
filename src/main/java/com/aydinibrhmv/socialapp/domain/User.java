package com.aydinibrhmv.socialapp.domain;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String password;
}
