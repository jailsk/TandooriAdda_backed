package com.resturant.tandoori_adda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
	@Column(name = "name")
	private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneno")
    private String phoneNo;
    @Column(name = "address")
    private String address;

    // Constructors, getters, and setters

    // ...
    public Customer(Long id, String name, String email, String phoneNo, String address) {
 		super();
 		this.id = id;
 		this.name = name;
 		this.email = email;
 		this.phoneNo = phoneNo;
 		this.address = address;
 	}
    
    public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address="
				+ address + "]";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
