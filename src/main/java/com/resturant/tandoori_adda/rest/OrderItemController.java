package com.resturant.tandoori_adda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resturant.tandoori_adda.entity.OrderItem;
import com.resturant.tandoori_adda.service.OrderItemService;
@CrossOrigin("*")
@RestController
@RequestMapping("/orderitems")
public class OrderItemController {
	
	
	  @Autowired
	    private OrderItemService orderItemService;
	  
	
	 
	 
	 @GetMapping("/{id}")
	 
	 public OrderItem getorder(@PathVariable int id) {
		 return orderItemService.getOrderItemById(id);
	 }

}
