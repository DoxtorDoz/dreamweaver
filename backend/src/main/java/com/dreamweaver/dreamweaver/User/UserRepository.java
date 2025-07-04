package com.dreamweaver.dreamweaver.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamweaver.dreamweaver.User.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
