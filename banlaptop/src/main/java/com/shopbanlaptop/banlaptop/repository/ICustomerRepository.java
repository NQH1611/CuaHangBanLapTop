package com.shopbanlaptop.banlaptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopbanlaptop.banlaptop.model.Customers;
//có sự thay đổi ở đây
public interface ICustomerRepository extends JpaRepository<Customers, Integer>{
    
}
