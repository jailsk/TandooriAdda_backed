package com.resturant.tandoori_adda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.entity.TandooriAddaOrder;
import com.resturant.tandoori_adda.service.AdminService;
import com.resturant.tandoori_adda.service.TandooriAddaOrderService;
import com.resturant.tandoori_adda.util.TokenUtil;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	
	 @GetMapping("/orders")
	    public List<TandooriAddaOrder> getAllOrders() {
	        List<TandooriAddaOrder> orders = adminService.getAllOrders();
	        return orders;
	    }
	
	
	 
	 @PostMapping("/add_menu")
	    public Menu createMenu(@RequestBody Menu menu) {
	        menu.setId(0);
	        
	        menu.setName(menu.getName().substring(0, 1).toUpperCase()+menu.getName().substring(1));
		 
		 return adminService.createMenu(menu);
	    }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateMenu(@PathVariable int id, @RequestBody Menu updatedMenu) {
	        Menu existingMenu = adminService.getMenuById(id);
	        if (existingMenu == null) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        updatedMenu.setName(updatedMenu.getName().substring(0, 1).toUpperCase()+updatedMenu.getName().substring(1));
	        adminService.updateMenu(id, updatedMenu);

	       

	        return ResponseEntity.ok("Menu item with ID " + id + " updated successfully.");
	    }
	 
	 @DeleteMapping("/{id}")
	    public void deleteMenu(@PathVariable int id) {
		 adminService.deleteMenu(id);
	    }
	 
	 
	 
	 @PostMapping("/email")
	    public String getUserEmail(@RequestHeader("Authorization") String idToken) {
	        try {
	            // Extract the token from the "Authorization" header
	            String token = idToken.substring(7); // Remove "Bearer " prefix

	            String email = TokenUtil.extractUsernameFromToken(token);
	            return "User Email: " + email;
	        } catch (FirebaseAuthException e) {
	            return "Error extracting user email: " + e.getMessage();
	        }
	    }
	 
//	 @PutMapping("/status_update/{id}")
//	 public String status_update(@PathVariable int id,@RequestBody TandooriAddaOrder tandooriaddaorder)
//	 {
//		 
//		 adminService.Status_update(id,tandooriaddaorder);
//		 return "sucess";
//	 }
//	 
	
	
}
