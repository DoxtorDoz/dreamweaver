package com.dreamweaver.dreamweaver.User.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dreamweaver.dreamweaver.Command;
import com.dreamweaver.dreamweaver.User.UserRepository;
import com.dreamweaver.dreamweaver.User.model.UpdateUserCommand;
import com.dreamweaver.dreamweaver.User.model.User;
import com.dreamweaver.dreamweaver.User.model.UserDTO;
//Cambiar devolucion de String a USERDTO
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO>{

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {
        Optional<User> optionalUser = userRepository.findById(command.getId());
        if(optionalUser.isPresent()){
            User user = command.getUser();
            user.setId(command.getId());
            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }
        return null;
    }
    
}
