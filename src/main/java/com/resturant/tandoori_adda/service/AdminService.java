package com.resturant.tandoori_adda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resturant.tandoori_adda.dao.CustomerRepository;
import com.resturant.tandoori_adda.dao.MenuRepository;
import com.resturant.tandoori_adda.dao.OrderItemRepository;
import com.resturant.tandoori_adda.dao.TandooriAddaOrderRepository;
import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.entity.OrderItem;
import com.resturant.tandoori_adda.entity.TandooriAddaOrder;

@Service
public class AdminService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	 private TandooriAddaOrderRepository orderRepository;

	  @Autowired
	  private OrderItemRepository orderItemRepository;
	
	 public List<TandooriAddaOrder> getAllOrders() {
	       return orderRepository.findAll();
	  }
	 
	 public List<OrderItem> getAllOrders_order_item(){
		 return orderItemRepository.findAll();
	 }
	
	
	 @Transactional
	 public Menu createMenu(Menu menu) {
	        return menuRepository.save(menu);
	    }
	 
	 
	 public Menu getMenuById(int id) {
	        return menuRepository.findById(id).orElse(null);
	    }
	 @Transactional
	 public void deleteMenu(int id) {
	        menuRepository.deleteById(id);
	    }
	 @Transactional
	 public Menu updateMenu(int id, Menu updatedMenu) {
	        Menu existingMenu = menuRepository.findById(id).orElse(null);
	        if (existingMenu != null) {
	            existingMenu.setName(updatedMenu.getName());
	            existingMenu.setPrice(updatedMenu.getPrice());
	            existingMenu.setStock(updatedMenu.getStock());
	            existingMenu.setImage(updatedMenu.getImage());
	            existingMenu.setCategory(updatedMenu.getCategory());
	            existingMenu.setDiscount(updatedMenu.getDiscount());
	            existingMenu.setDiscription(updatedMenu.getDescription());
	            return menuRepository.save(existingMenu);
	        }
	        return null;
	    }

	public TandooriAddaOrder Status_update(int id, TandooriAddaOrder tandooriaddaorder) {
		
		TandooriAddaOrder existingOrder = orderRepository.findById(id).orElse(null);
		if(existingOrder != null)
		{
			existingOrder.setOrder_status(tandooriaddaorder.getOrder_status());
			return orderRepository.save(existingOrder);
		}
		return null;
		
	}


	

}
