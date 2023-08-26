package com.resturant.tandoori_adda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resturant.tandoori_adda.dao.MenuRepository;
import com.resturant.tandoori_adda.entity.Menu;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
    
    public Menu getItemByName(String itemName) {
        return menuRepository.findByNameIgnoreCase(itemName);
    }
    
    
    public Menu findbyid(int id) {
        return menuRepository.findById(id).orElse(null);
    }
    @Transactional
    public Menu updateMenu(int id, Menu updatedMenu) {
        Optional<Menu> existingMenuOptional = menuRepository.findById(id);

        if (existingMenuOptional.isPresent()) {
            Menu existingMenu = existingMenuOptional.get();
            
            existingMenu.setRating(updatedMenu.getRating());

            return menuRepository.save(existingMenu);
        } else {
            // Handle the case when the menu item with the given ID doesn't exist
            throw new RuntimeException("Menu not found with ID: " + id);
        }
    }
}