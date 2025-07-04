package com.dreamweaver.dreamweaver;

import org.springframework.http.ResponseEntity;
//Utiliazmos Query para obtener datos (READ)
public interface Query<I,O> {
    ResponseEntity<O> execute(I input);
}
