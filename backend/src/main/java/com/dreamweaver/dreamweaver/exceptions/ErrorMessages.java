package com.dreamweaver.dreamweaver.exceptions;

public enum ErrorMessages {

    USER_NOT_FOUND("User not found"),
    TAG_NOT_FOUND("Tag not found");


    private final String msg;

    ErrorMessages(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
