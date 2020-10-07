package com.enriccomesbackend.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="shops")
public class Shop {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (length=50, nullable=false)
	private String name;
	
	@Column (length=1000, nullable=false)
	private Long maxCapacity;

	@OneToMany(
			mappedBy = "shop",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Picture> pictures = new ArrayList<>();

	//constructors	
	@SuppressWarnings("unused")
	private Shop() {
	}
	
	public Shop(String name, Long maxCapacity) {
		this.name = name;
		this.maxCapacity = maxCapacity;
	}

	//getters & setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Long maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	//other getter for pictures
	public List<Picture> obtenerPictures(){
		return pictures;
	}
	
}
