package com.resturant.tandoori_adda.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tandooriadda_order")
public class TandooriAddaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    
    
    
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "email")
    private String email;
	@Column(name = "last_name")
    private String last_name;
    
	@Column(name = "order_date")
    private Date order_date;
    

	@Column(name = "total_amount")
    private double total_amount;
    @Column(name = "payment_method")
    private String payment_method;
    @Column(name = "delivery_address")
    private String delivery_address;
    @Column(name = "contact_number")
    private String contact_number;
    @Column(name = "special_instructions")
    private String special_instructions;
    @Column(name = "order_status")
    private String order_status;

    @OneToMany(mappedBy = "tandooriAddaOrder", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

	
   

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getSpecial_instructions() {
		return special_instructions;
	}

	public void setSpecial_instructions(String special_instructions) {
		this.special_instructions = special_instructions;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public TandooriAddaOrder(int order_id, String first_name, String email, String last_name, Date order_date,
			double total_amount, String payment_method, String delivery_address, String contact_number,
			String special_instructions, String order_status, List<OrderItem> orderItems) {
		super();
		this.order_id = order_id;
		this.first_name = first_name;
		this.email = email;
		this.last_name = last_name;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
		this.delivery_address = delivery_address;
		this.contact_number = contact_number;
		this.special_instructions = special_instructions;
		this.order_status = order_status;
		this.orderItems = orderItems;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "TandooriAddaOrder [order_id=" + order_id + ", first_name=" + first_name + ", email=" + email
				+ ", last_name=" + last_name + ", order_date=" + order_date + ", total_amount=" + total_amount
				+ ", payment_method=" + payment_method + ", delivery_address=" + delivery_address + ", contact_number="
				+ contact_number + ", special_instructions=" + special_instructions + ", order_status=" + order_status
				+ ", orderItems=" + orderItems + "]";
	}

	public TandooriAddaOrder() {
		super();
	}

   
}