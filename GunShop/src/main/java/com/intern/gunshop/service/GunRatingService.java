package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.entity.Gun_Rating;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.repository.GunRatingRepository;
import com.intern.gunshop.repository.GunRepository;
import com.intern.gunshop.repository.UserRepository;

@Service
public class GunRatingService {
	
	@Autowired
	private GunRatingRepository rateRepo;
	
	@Autowired
	private GunRepository gunRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Gun_Rating rate(int gun_id, int user_id, int rated_point) {
		Gun gun = gunRepo.findById(gun_id).get();
		Users user = userRepo.findById(user_id).get();
		LocalDateTime now = LocalDateTime.now();
		Timestamp rated_date = Timestamp.valueOf(now);
		Gun_Rating ratedGun = new Gun_Rating(gun, user, rated_point, rated_date);		
		return rateRepo.save(ratedGun);
	}
	
}
