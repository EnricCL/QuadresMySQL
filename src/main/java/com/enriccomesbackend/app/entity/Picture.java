package com.enriccomesbackend.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name="pictures")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String author;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String price;
	
	@Column(length = 10, nullable = false)
	private String entryDate;
	
	@ManyToOne
	@JoinColumn(name = "shop_id",nullable=false)
	private Shop shop;

	//constructors
	@SuppressWarnings("unused")
	private Picture() {
		
	}
		
	public Picture(String author, String name, String price, String entryDate, Shop shop) {
		this.author = author;
		this.name = name;
		this.price = price;
		this.entryDate = entryDate;
		this.shop = shop;
	}

	public Picture(String name, String price) {
		this.name = name;
		this.price = price;
	}

	//setters & getters
	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
		
}
