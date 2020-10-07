package com.enriccomesbackend.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enriccomesbackend.app.entity.Picture;
import com.enriccomesbackend.app.entity.Shop;
import com.enriccomesbackend.app.repository.PictureRepository;
import com.enriccomesbackend.app.repository.ShopRepository;

@Service
@Transactional
public class PictureServiceImpl implements PictureService{
	
	@Autowired
	private PictureRepository pictureRepository;
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public List<Picture> findAllPicturesByShop(Long shopId) {
		
		return pictureRepository.findPicturesByShopId(shopId);
		
	}

	@Override
	public Picture createPicture(Picture picture, Long shopId) {
		
		Optional<Shop> shop = shopRepository.findById(shopId);
		
		//check if shop exists
		if(shop.isPresent()) {
			
			int maxCapacity = shop.get().getMaxCapacity().intValue();
			
			//check if the picture is the first of the shop or next
			if(shop.get().obtenerPictures().isEmpty()) {
				
				Shop shop2 = shopRepository.getOne(shopId);
				
				Picture newPicture = new Picture(	
						picture.getAuthor(),
						picture.getName(),
						picture.getPrice(),
						picture.getEntryDate(),
						shop2);
				
				return pictureRepository.save(newPicture);
				
		
			}else {
				
				//count actuals pictures exists in the shop
				List<Picture> pictures = shop.get().obtenerPictures();
				int countPictures = 0;
				for(@SuppressWarnings("unused") Picture actualPicture : pictures)countPictures++;
				
				//If the maximum capacity is not equal
				if(countPictures < maxCapacity) {
						
					Shop shop2 = shopRepository.getOne(shopId);
							
					Picture newPicture = new Picture(	
						picture.getAuthor(),
						picture.getName(),
						picture.getPrice(),
						picture.getEntryDate(),
						shop2);
							
					return pictureRepository.save(newPicture);
				}
							
			}
			
		}
		
		return pictureRepository.save(null);
		
	}

	@Override
	public void deleteAllPicturesByShop(Long shopId) {
		
		List<Picture> pictureList = findAllPicturesByShop(shopId);
		for(Picture picture: pictureList) pictureRepository.delete(picture);
		
	}

}
