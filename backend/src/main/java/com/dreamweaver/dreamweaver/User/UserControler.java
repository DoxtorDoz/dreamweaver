package com.dreamweaver.dreamweaver.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dreamweaver.dreamweaver.User.model.UserDTO;
import com.dreamweaver.dreamweaver.User.services.CreateUserService;
import com.dreamweaver.dreamweaver.User.services.DeleteUserService;
import com.dreamweaver.dreamweaver.User.services.GetUserService;
import com.dreamweaver.dreamweaver.User.services.GetUsersService;
import com.dreamweaver.dreamweaver.User.services.UpdateUserService;

import java.util.List;

import com.dreamweaver.dreamweaver.User.model.UpdateUserCommand;
import com.dreamweaver.dreamweaver.User.model.User;

public class UserControler {

    private CreateUserService createUserService;
    private GetUsersService getUsersService;
    private GetUserService getUserService;
    private UpdateUserService updateUserService;
    private DeleteUserService deleteUserService;
    
    public UserControler(CreateUserService createUserService, GetUsersService getUsersService, GetUserService getUserService,UpdateUserService updateUserService, DeleteUserService deleteUserService){
        this.createUserService = createUserService;
        this.getUsersService = getUsersService;
        this.getUserService = getUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }

    @PostMapping("/product")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return createUserService.execute(user);
    }

    @GetMapping("/products")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return getUsersService.execute(null);
    } 

    @GetMapping("/product/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        return getUserService.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user){
        return updateUserService.execute(new UpdateUserCommand(id, user));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        return deleteUserService.execute(id);
    }
    
}
