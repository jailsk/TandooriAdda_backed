package com.resturant.tandoori_adda.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.resturant.tandoori_adda.entity.Menu;
import com.resturant.tandoori_adda.entity.TandooriAddaOrder;
import com.resturant.tandoori_adda.service.AdminService;
import com.resturant.tandoori_adda.service.MenuService;
import com.resturant.tandoori_adda.service.TandooriAddaOrderService;
import com.resturant.tandoori_adda.util.TokenUtil;

@CrossOrigin("*")
@RestController
public class MenuWebSocketController {
	
	
	@Autowired
	public AdminService adminService; 
    
    @Autowired
    private  TandooriAddaOrderService orderService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    // Send menu data to connected clients
    @MessageMapping("/menu/create_order")
    @SendTo("/topic/menu/admin/all_orders")
    public List<TandooriAddaOrder> getMenu(@Header("Authorization") String idToken,@Payload TandooriAddaOrder order ) throws Exception {
        
        System.out.println(idToken);
        System.out.println(order);
    	String token = idToken.substring(7);
    	String email = TokenUtil.extractUsernameFromToken(token);
    	
    	orderService.createOrder(order,email);
    	
    	return adminService.getAllOrders();
    }
  
    
    @MessageMapping("/admin/status_update")
    public void status_update(@Payload TandooriAddaOrder order)
    {	System.out.println(order.getOrder_id());
    	System.out.println("ghus gaya");
    	TandooriAddaOrder tao=	adminService.Status_update(order.getOrder_id(),order);
    	
    	String customerEmail = tao.getEmail();
    	
    	String destination = "/user/" + customerEmail + "/queue/order-updates";
    	 
    	messagingTemplate.convertAndSend(destination, tao);
    	 
    	 System.out.println(destination);
    	
    	
    }
    
    
    
    
    
}







