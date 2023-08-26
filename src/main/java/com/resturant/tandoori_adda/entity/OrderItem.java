package com.resturant.tandoori_adda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int item_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private TandooriAddaOrder tandooriAddaOrder;
    
    @Column(name = "item_name")
    private String item_name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private Double price;
    
    @Column(name = "rating")
    private Double rating;
    
    @Column(name = "review")
    private String review;
	
    
    
    
    public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public OrderItem(int item_id, TandooriAddaOrder tandooriAddaOrder, String item_name, int quantity, Double price,
			Double rating, String review) {
		super();
		this.item_id = item_id;
		this.tandooriAddaOrder = tandooriAddaOrder;
		this.item_name = item_name;
		this.quantity = quantity;
		this.price = price;
		this.rating = rating;
		this.review = review;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public TandooriAddaOrder getTandooriAddaOrder() {
		return tandooriAddaOrder;
	}
	public void setTandooriAddaOrder(TandooriAddaOrder tandooriAddaOrder) {
		this.tandooriAddaOrder = tandooriAddaOrder;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	@Override
	public String toString() {
		return "OrderItem [item_id=" + item_id + ", tandooriAddaOrder=" + tandooriAddaOrder + ", item_name=" + item_name
				+ ", quantity=" + quantity + ", price=" + price + ", rating=" + rating + ", review=" + review + "]";
	}
	
	public OrderItem() {
		super();
	}

   
}