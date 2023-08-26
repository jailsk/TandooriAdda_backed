package com.resturant.tandoori_adda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resturant.tandoori_adda.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional custom queries can be added here if needed
}