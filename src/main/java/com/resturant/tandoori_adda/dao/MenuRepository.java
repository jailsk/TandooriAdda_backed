package com.resturant.tandoori_adda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturant.tandoori_adda.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	Menu findByNameIgnoreCase(String name);
}
