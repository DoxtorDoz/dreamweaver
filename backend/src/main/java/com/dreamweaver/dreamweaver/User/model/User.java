package com.dreamweaver.dreamweaver.User.model;

import java.util.List;

import com.dreamweaver.dreamweaver.Dream.model.Dream;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity //Mapea la clase java con la tabla SQL
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private Long id;

    @ NotNull(message = "'username' is required")
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "name", nullable = false)
    private String name;

    @ NotNull(message = "'email' is required")
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "dreams", nullable = false)
    private List<Dream> dreams;


    public User(){}

    public User(String userName, String email, String name, String description){
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dream> getDreams() {
        return dreams;
    }

    public void setDreams(List<Dream> dreams) {
        this.dreams = dreams;
    }
    
    
}
