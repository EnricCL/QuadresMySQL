package com.enriccomesbackend.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enriccomesbackend.app.entity.Picture;

import com.enriccomesbackend.app.service.PictureService;
import com.enriccomesbackend.app.service.ShopService;


@RestController
@RequestMapping("/shops")
public class PictureController {
	
	@Autowired
	PictureService pictureService;
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/{ID}/pictures")
	public ResponseEntity<?> getAllPicturesByShop(@PathVariable ("ID") long shopId){
		
		List<Picture> pictures = pictureService.findAllPicturesByShop(shopId);
		
		if(pictures.isEmpty()) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			
			return new ResponseEntity<String>("[]",headers, HttpStatus.BAD_REQUEST);
			
		}else return ResponseEntity.ok().body(pictureService.findAllPicturesByShop(shopId));
			
			
		
	}
	
	@PostMapping(value="/{ID}/pictures", produces="application/json")
	public ResponseEntity<?> createPicture (	@RequestBody Picture picture, 
												@PathVariable("ID") long shopId){
				
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
				
		try {
			
			return ResponseEntity		
					.status(HttpStatus.CREATED)
					.body(pictureService.createPicture(picture, shopId));
			
		}catch(Exception e){	
			
			return new ResponseEntity<String>("[]",headers, HttpStatus.BAD_REQUEST);
			
		}	
					
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{ID}/pictures")
	public ResponseEntity deletePicturesByShop (@PathVariable("ID") long shopId) {
		
		List<Picture> pictures = pictureService.findAllPicturesByShop(shopId);
		
		if(pictures.isEmpty()) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			
			return new ResponseEntity<String>("[]",headers, HttpStatus.BAD_REQUEST);
			
		}else {
		
			pictureService.deleteAllPicturesByShop(shopId);
			return ResponseEntity.ok().build();
			
		}
	}

}
