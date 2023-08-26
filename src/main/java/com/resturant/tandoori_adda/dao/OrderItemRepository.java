package com.resturant.tandoori_adda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturant.tandoori_adda.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // Add custom query methods if needed
}
