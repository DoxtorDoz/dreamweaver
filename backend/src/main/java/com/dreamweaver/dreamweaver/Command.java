package com.dreamweaver.dreamweaver;

import org.springframework.http.ResponseEntity;

//Utilizamos Command para realizar acciones (CREATE, UPDATE, DELETE)
public interface Command<I,O> {
    ResponseEntity<O> execute(I input);
}
