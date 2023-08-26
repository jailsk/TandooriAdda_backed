package com.resturant.tandoori_adda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resturant.tandoori_adda.dao.TandooriAddaOrderRepository;
import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.entity.OrderItem;
import com.resturant.tandoori_adda.entity.TandooriAddaOrder;

import java.util.List;

@Service
public class TandooriAddaOrderService {

    private final TandooriAddaOrderRepository orderRepository;

    @Autowired
    public TandooriAddaOrderService(TandooriAddaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private MenuService menuService;

    public TandooriAddaOrder getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    
    @Transactional
    public TandooriAddaOrder createOrder(TandooriAddaOrder order, String email) throws Exception {
    	double bill=0.0;
    	order.setOrder_id(0);
    	order.setEmail(email);
    	order.setOrder_status("placed");
    	
    	if (order.getOrderItems()==null)
    	{
    		throw new Exception("item is empty");
    	}
    	for (OrderItem item : order.getOrderItems()) {
    		item.setItem_id(0);
    		item.setRating(null);
    		item.setReview(null);
    		
    		
    		Menu menu=menuService.getItemByName(item.getItem_name());
    		
    		//Menu menu= menuService.findbyid(item.getItem_id()); //id bhaj do 
    		
    		item.setPrice(menu.getPrice()-menu.getDiscount());
    		bill=bill+item.getPrice()*item.getQuantity();
    	
    	}
    	order.setTotal_amount(bill);
    	
    	TandooriAddaOrder tao=orderRepository.save(order);
    	
    	for (OrderItem item : order.getOrderItems()) {
    	
    		item.setTandooriAddaOrder(tao);
    	orderItemService.createOrderItem(item);
    	
    	}
    	return null;
    }
    @Transactional
    public TandooriAddaOrder updateOrder(TandooriAddaOrder order) {
        return orderRepository.save(order);
    }
    @Transactional
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

	public List<TandooriAddaOrder> getOrderByEmail(String email) {
		
		return orderRepository.findByEmail(email);
	}

	public String add_review_and_rating(String email, int totalOrder_id, int item_id, OrderItem order) throws Throwable {
		
		TandooriAddaOrder tandooriAddaOrder=getOrderById(totalOrder_id);
		
		
		if(!tandooriAddaOrder.getOrder_status().equals("delivered"))
		{
			throw new Exception("you can't perform this action until the order is delivered");
		}
		
		if(!tandooriAddaOrder.getEmail().equals(email))
		{
			throw new Exception("you can't perform this action");
		}
		
		for(OrderItem orderItem : tandooriAddaOrder.getOrderItems())
		{
			if(orderItem.getItem_id()==item_id)
			{				
				orderItemService.updateOrderItem(item_id, order);
				
				
				return null;
			}
			
			
			
		}
		
		throw new Exception("you don't have this order");
	}
}
