package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.RatingDTO;
import com.intern.gunshop.dto.ResponseMessage;
import com.intern.gunshop.dto.ResponseRating;
import com.intern.gunshop.entity.Gun_Rating;
import com.intern.gunshop.service.GunRatingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rate")
@Tag(name = "Rating")
public class GunRatingController {

	@Autowired
	private GunRatingService service;
	
	//Rate a gun
	@Operation(summary = "Rate a gun", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = Gun_Rating.class), mediaType = "application/json")) })
	@PostMapping("/{gun_id}/{user_id}/{rated_point}")
	public ResponseEntity<RatingDTO> rateAgun(@PathVariable Integer gun_id, 
												@PathVariable Integer user_id,
												@PathVariable Integer rated_point){
		
		RatingDTO ratedGun = service.rate(gun_id, user_id, rated_point);
		
		return new ResponseEntity<RatingDTO>(ratedGun,HttpStatus.CREATED);
	}
	
	//Get average rating of a gun
	@Operation(summary = "Get average rating of a gun", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseRating.class), mediaType = "application/json")) })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseRating> getAverage(@PathVariable Integer id){
		ResponseRating rating = new ResponseRating();
		double avg = service.averageRating(id);
		rating.setRate(avg);
		return new ResponseEntity<ResponseRating>(rating,HttpStatus.OK);
	}
	
	//Get all rating
	@Operation(summary = "Get all rating", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = RatingDTO.class), mediaType = "application/json")) })
	@GetMapping()
	public ResponseEntity<List<RatingDTO>> getAllRating(@RequestParam Integer gun_id){
		List<RatingDTO> ratingList = service.getAllRating(gun_id);
		return new ResponseEntity<List<RatingDTO>>(ratingList,HttpStatus.OK);
	}
	
	//Delete rating
	@Operation(summary = "Delete a rating", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = String.class), mediaType = "application/json")) })
	@DeleteMapping("/{rate_id}")
	public ResponseEntity<ResponseMessage> deleteRating(@PathVariable Integer rate_id){
		service.deleteRating(rate_id);
		ResponseMessage msg = new ResponseMessage();
		msg.setMessage("Deleted !");
		return new ResponseEntity<ResponseMessage>(msg, HttpStatus.OK);
	}
}
