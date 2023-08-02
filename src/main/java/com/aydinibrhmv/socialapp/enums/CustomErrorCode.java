package com.aydinibrhmv.socialapp.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {

USER_NOT_FOUND(101,"User with id was not found"),
POST_NOT_FOUND(102,"Post with id was not found"),;


    private  final int code;
    private  final String message;
}
