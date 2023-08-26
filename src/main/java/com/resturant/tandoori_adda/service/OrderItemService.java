package com.resturant.tandoori_adda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resturant.tandoori_adda.dao.OrderItemRepository;
import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.entity.OrderItem;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private MenuService menuService;

    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {

     return orderItemRepository.save(orderItem);
    }

    @Transactional(readOnly = true)
    public OrderItem getOrderItemById(int itemId) {
        return orderItemRepository.findById(itemId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

   
    @Transactional
    public OrderItem updateOrderItem(int id, OrderItem updatedOrderItem) throws Throwable {
        
    	OrderItem existingOrderItem = orderItemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
        
        
        
        if(existingOrderItem.getRating()!=null || existingOrderItem.getReview()!=null)
      {
        	throw new Exception("review or rating already present " + id);
        }
        
        if (updatedOrderItem.getRating()>5.0||updatedOrderItem.getRating()<0)
        {
        	throw new Exception("rating should be less than 5 " + id);
        }
        
        		Menu menu=menuService.getItemByName(existingOrderItem.getItem_name());
        	
        	if(menu.getRating()==null) {
        		menu.setRating(updatedOrderItem.getRating());
        }
        else {
        	menu.setRating((menu.getRating()+updatedOrderItem.getRating())/2);
        }
        
        existingOrderItem.setRating(updatedOrderItem.getRating());
        existingOrderItem.setReview(updatedOrderItem.getReview());
        
        menuService.updateMenu(menu.getId(), menu);
        return orderItemRepository.save(existingOrderItem);
    }

    @Transactional
    public void deleteOrderItem(int itemId) {
        orderItemRepository.deleteById(itemId);
    }
}