package com.dreamweaver.dreamweaver.User.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dreamweaver.dreamweaver.Command;
import com.dreamweaver.dreamweaver.User.UserRepository;
import com.dreamweaver.dreamweaver.User.model.User;
import com.dreamweaver.dreamweaver.exceptions.ElementNotFoundException;
import com.dreamweaver.dreamweaver.exceptions.ErrorMessages;

public class DeleteUserService implements Command<Long, Void>{

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long input) {
        Optional<User> optionalUser = userRepository.findById(input);
        if(optionalUser.isPresent()){
            userRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ElementNotFoundException(ErrorMessages.TAG_NOT_FOUND.getMsg());
    }
    
}
