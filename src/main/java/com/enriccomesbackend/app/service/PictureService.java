package com.enriccomesbackend.app.service;

import java.util.List;

import com.enriccomesbackend.app.entity.Picture;

public interface PictureService {

	public List<Picture> findAllPicturesByShop(Long shopId);
		
	public Picture createPicture(Picture picture, Long shopId);
	
	public void deleteAllPicturesByShop(Long shopId);	
	
}