package com.shopbanlaptop.banlaptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbanlaptop.banlaptop.model.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
    
}
