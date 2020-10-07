package com.enriccomesbackend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enriccomesbackend.app.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
