package com.dreamweaver.dreamweaver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String msg){
        
        super(msg);
    }
}
