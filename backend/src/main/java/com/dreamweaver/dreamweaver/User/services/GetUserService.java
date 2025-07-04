package com.dreamweaver.dreamweaver.User.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dreamweaver.dreamweaver.Query;
import com.dreamweaver.dreamweaver.User.UserRepository;
import com.dreamweaver.dreamweaver.User.model.User;
import com.dreamweaver.dreamweaver.User.model.UserDTO;

public class GetUserService implements Query<Long, UserDTO>{

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Long input) {
        Optional<User> optionaluser  = userRepository.findById(input);
        if(optionaluser.isPresent()){
            return ResponseEntity.ok(new UserDTO(optionaluser.get()));
        }
        return null;
    }
    
}
