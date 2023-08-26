package com.resturant.tandoori_adda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.firebase.auth.FirebaseAuthException;
import com.resturant.tandoori_adda.entity.OrderItem;
import com.resturant.tandoori_adda.entity.TandooriAddaOrder;
import com.resturant.tandoori_adda.service.TandooriAddaOrderService;
import com.resturant.tandoori_adda.util.TokenUtil;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class TandooriAddaOrderController {

    private final TandooriAddaOrderService orderService;

    @Autowired
    public TandooriAddaOrderController(TandooriAddaOrderService orderService) {
        this.orderService = orderService;
    }

   

//    @GetMapping("/{orderId}")
//    public ResponseEntity<TandooriAddaOrder> getOrderById(@PathVariable int orderId) {
//        TandooriAddaOrder order = orderService.getOrderById(orderId);
//        if (order == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(order, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<TandooriAddaOrder> createOrder(@RequestBody TandooriAddaOrder order) throws Exception {
        String email="srb7309264849@gmail.com";
		TandooriAddaOrder createdOrder = orderService.createOrder(order,email);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<TandooriAddaOrder> updateOrder(@PathVariable int orderId, @RequestBody TandooriAddaOrder order) {
        TandooriAddaOrder updatedOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
//
//    @DeleteMapping("/{orderId}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
//        orderService.deleteOrder(orderId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    
    @GetMapping("/email")
    public List<TandooriAddaOrder> get_order_by_email(@RequestHeader("Authorization") String idToken) throws Exception
    {
    	System.out.println(idToken);
    	String token = idToken.substring(7);
    	String email = TokenUtil.extractUsernameFromToken(token);
    	System.out.println("Customer Order");
		return orderService.getOrderByEmail(email);
    }
    
    @PutMapping("/review/{tandooriAddaOrder}/{orderId}")
    public String add_review_and_rating(@RequestHeader("Authorization") String idToken,@PathVariable int tandooriAddaOrder,@PathVariable int orderId, @RequestBody OrderItem order) throws Throwable
    {String token = idToken.substring(7);
	String email = TokenUtil.extractUsernameFromToken(token);
		
    	System.out.println("rating");
	return orderService.add_review_and_rating(email,tandooriAddaOrder,orderId,order);
    }
}