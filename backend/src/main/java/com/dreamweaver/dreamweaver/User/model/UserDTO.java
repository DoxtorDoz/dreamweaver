package com.dreamweaver.dreamweaver.User.model;

import java.util.List;

import com.dreamweaver.dreamweaver.Dream.model.Dream;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String name;
    private String email;
    private String description;
    private List<Dream> dreams;

    

    public UserDTO(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.email = user.getEmail();
        this.description = user.getDescription();
        this.dreams = user.getDreams();
    }
}
