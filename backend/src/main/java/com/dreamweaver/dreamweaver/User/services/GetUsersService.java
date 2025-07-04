package com.dreamweaver.dreamweaver.User.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dreamweaver.dreamweaver.Query;
import com.dreamweaver.dreamweaver.User.UserRepository;
import com.dreamweaver.dreamweaver.User.model.User;
import com.dreamweaver.dreamweaver.User.model.UserDTO;


public class GetUsersService implements Query<Void, List<UserDTO>>{

    private final UserRepository userRepository;

    //Inyectamos por constructor en vez de emplear Autowired
    public GetUsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
    }
}
