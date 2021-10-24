package com.intern.gunshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.entity.Gun_Rating;
import com.intern.gunshop.service.GunRatingService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rate")
@Tag(name = "Rating")
public class GunRatingController {

	@Autowired
	private GunRatingService service;
	
	@PostMapping("/{gun_id}/{user_id}/{rated_point}")
	public ResponseEntity<Gun_Rating> rateAgun(@PathVariable Integer gun_id, 
												@PathVariable Integer user_id,
												@PathVariable Integer rated_point){
		
		Gun_Rating ratedGun = service.rate(gun_id, user_id, rated_point);
		
		return new ResponseEntity<Gun_Rating>(ratedGun,HttpStatus.OK);
	}
}
