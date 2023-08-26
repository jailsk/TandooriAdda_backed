package com.resturant.tandoori_adda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.service.MenuService;
@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAllMenus() {
    	
    	System.out.println("menu");
        return menuService.getAllMenus();
    }



//    @PutMapping("/{id}")
//    public Menu updateMenu(@PathVariable int id, @RequestBody Menu updatedMenu) {
//        return menuService.updateMenu(id, updatedMenu);
//    }
}