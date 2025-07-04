package com.dreamweaver.dreamweaver.User.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dreamweaver.dreamweaver.Command;
import com.dreamweaver.dreamweaver.User.UserRepository;
import com.dreamweaver.dreamweaver.User.model.User;
import com.dreamweaver.dreamweaver.User.model.UserDTO;

@Service
public class CreateUserService implements Command<User, UserDTO>{

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User input) {
        User savedUser = userRepository.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }
}
