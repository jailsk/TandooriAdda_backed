package com.resturant.tandoori_adda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturant.tandoori_adda.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Add custom query methods if needed
}