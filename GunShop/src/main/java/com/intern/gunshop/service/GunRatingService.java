package com.intern.gunshop.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.RatingDTO;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.entity.Gun_Rating;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.repository.GunRatingRepository;
import com.intern.gunshop.repository.GunRepository;
import com.intern.gunshop.repository.UserRepository;
import com.intern.gunshop.util.GetTime;
import com.intern.gunshop.util.Validator;

@Service
public class GunRatingService {
	
	@Autowired
	private GunRatingRepository rateRepo;
	
	@Autowired
	private GunRepository gunRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//Rate a gun
	public RatingDTO rate(int gun_id, int user_id, int rated_point) {
		Validator.checkRatePoint(rated_point);
		Gun gun = gunRepo.findById(gun_id).get();
		Users user = userRepo.findById(user_id).get();		
		Gun_Rating ratedGun = new Gun_Rating();
		ratedGun.setGun(gun);
		ratedGun.setUser(user);
		ratedGun.setRated_date(GetTime.getTimestamp());
		ratedGun.setRated_point(rated_point);
		rateRepo.save(ratedGun);
		RatingDTO dto = new RatingDTO();
		dto.setGun_name(gun.getGun_name());
		dto.setUser_name(user.getUser_name());
		dto.setRate_point(rated_point);
		return dto;
	}
	
	//Get all rating of a gun
	public Map<String, String> getAllRating(Integer id){
		Map<String, String> rateList = new HashMap<String, String>();
		List<Gun_Rating> list = rateRepo.getAllRatingOfGun(id);
		for(Gun_Rating rate : list) {
			rateList.put(rate.getUser().getUser_name(), String.valueOf(rate.getRated_point()));
		}
		return rateList;
	}
	
	//Get average rating of a gun
	public double averageRating(int gun_id) {
		String result =  rateRepo.averageRateOfGun(gun_id);
		if(result == null) {
			return 0;
		}
		return Double.parseDouble(result);
	}
	
	//Delete a rating
	public void deleteRating(Integer id) {
		try {
		rateRepo.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ApiRequestException("No rating to delete");
		}
	}
}
