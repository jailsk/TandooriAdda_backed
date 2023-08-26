package com.resturant.tandoori_adda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturant.tandoori_adda.entity.TandooriAddaOrder;

public interface TandooriAddaOrderRepository extends JpaRepository<TandooriAddaOrder, Integer> {
    
	
	List<TandooriAddaOrder> findByEmail(String email); 
}
