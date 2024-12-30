package com.lasen.projectmanagementsystem.controller;

import com.lasen.projectmanagementsystem.model.User;
import com.lasen.projectmanagementsystem.repository.UserRepository;
import com.lasen.projectmanagementsystem.service.CustomUserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailImpl customUserDetail;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) throws Exception{
        User isUserExsists = userRepository.findByEmail(user.getEmail());
        if(isUserExsists!=null){
            throw new Exception("email already exisits with another account");
        }
        User createdUser = new User();
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());
        User savedUser  = userRepository.save(createdUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
