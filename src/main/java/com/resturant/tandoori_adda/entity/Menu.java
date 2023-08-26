package com.resturant.tandoori_adda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Menu {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "id")
	 	private int id;
	 	@Column(name = "name")
	    private String name;
	 	@Column(name = "price")
	    private double price;
	 	@Column(name = "stock")
	    private Integer stock;
	 	@Column(name = "image")
	    private String image;
	 	@Column(name = "category")
	 	private String category;
	 	@Column(name = "discount")
	    private Double discount;
	 	@Column(name = "description")
	 	private String description;
	 	@Column(name = "rating")
	    private Double rating;
	 	
	 	
	 	
	    
	    public Double getRating() {
			return rating;
		}



		public void setRating(Double rating) {
			this.rating = rating;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public Menu(int id, String name, double price, Integer stock, String image, String category, Double discount,
				String description, Double rating) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.stock = stock;
			this.image = image;
			this.category = category;
			this.discount = discount;
			this.description = description;
			this.rating = rating;
		}



		public Menu(int id, String name, double price, Integer stock, String image, String category, Double discount,
				String description) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.stock = stock;
			this.image = image;
			this.category = category;
			this.discount = discount;
			this.description = description;
		}

		

		public String getDescription() {
			return description;
		}



		public void setDiscription(String description) {
			this.description = description;
		}



		public Double getDiscount() {
			return discount;
		}

		public void setDiscount(Double discount) {
			this.discount = discount;
		}

	

		// Constructors, getters, and setters

	    public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public Menu() {
	    }

	   

		@Override
		public String toString() {
			return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", image=" + image
					+ ", category=" + category + ", discount=" + discount + ", description=" + description + ", rating="
					+ rating + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
	    

}
