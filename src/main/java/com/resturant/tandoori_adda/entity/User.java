package com.resturant.tandoori_adda.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
    private String email;
    private String username;
    private String address;
    private String phone_no;

    // Constructors, getters, and setters
}