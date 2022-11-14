package com.shopbanlaptop.banlaptop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopbanlaptop.banlaptop.model.User;
import com.shopbanlaptop.banlaptop.repository.IUserRepository;

@RestController
@CrossOrigin
public class CUserController {
    @Autowired
    IUserRepository pUserRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> lstUser = new ArrayList<User>();
        pUserRepository.findAll().forEach(lstUser::add);
        if(lstUser.size() != 0) return new ResponseEntity<>(lstUser, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        Optional<User> user = pUserRepository.findById(id);
        if(user.isPresent()) return new ResponseEntity<>(user.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            User saveUser = pUserRepository.save(newUser);
            return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
