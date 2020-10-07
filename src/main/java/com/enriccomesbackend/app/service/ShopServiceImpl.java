package com.enriccomesbackend.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enriccomesbackend.app.entity.Shop;
import com.enriccomesbackend.app.repository.ShopRepository;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Iterable<Shop> findAll() {		
		return shopRepository.findAll();
	}

	@Override
	public Optional<Shop> findById(Long id) {
		return shopRepository.findById(id);
	}

	@Override
	public Shop save(Shop shop) {
		return shopRepository.save(shop);
	}

}
