package com.enriccomesbackend.app.service;

import java.util.Optional;

import com.enriccomesbackend.app.entity.Shop;

public interface ShopService {
	
	public Iterable<Shop> findAll();
	
	public Optional<Shop> findById(Long id);

	public Shop save(Shop shop);
}
