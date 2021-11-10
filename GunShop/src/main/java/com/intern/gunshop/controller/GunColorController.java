package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.PaintGunDTO;
import com.intern.gunshop.entity.Color;
import com.intern.gunshop.request.PaintGunRequest;
import com.intern.gunshop.service.GunColorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/paint")
@Tag(name = "Gun's Paint")
public class GunColorController {
	
	@Autowired
	private GunColorService service;
	
	//Add new color to gun
	@Operation(summary = "Add color to gun", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = PaintGunDTO.class), mediaType = "application/json")) })
	@PostMapping()
	public ResponseEntity<PaintGunDTO> addPain(@RequestBody PaintGunRequest request){
		return new ResponseEntity<PaintGunDTO>(service.paintGun(request),HttpStatus.CREATED);
	}
	
	//Get all gun color
	@Operation(summary = "Get all gun color", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@GetMapping("/{gun_id}")
	public ResponseEntity<List<Color>> getColorByGun(@PathVariable Integer gun_id){
		return new ResponseEntity<List<Color>>(service.getColor(gun_id),HttpStatus.OK);
	}
	
	//Change color status
	@Operation(summary = "Change color status", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@PutMapping("/{colored_id}")
	public ResponseEntity<PaintGunDTO> changeStatus(@PathVariable Integer colored_id){
		PaintGunDTO dto = service.changeStatus(colored_id);
		return new ResponseEntity<PaintGunDTO>(dto,HttpStatus.ACCEPTED);
	}
	
	//Update quantity
	@Operation(summary = "Update color quantity", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@PutMapping()
	public ResponseEntity<PaintGunDTO> updateQuantity(@RequestParam Integer id, @RequestParam int quantity){
		PaintGunDTO dto = service.updateQuantity(id, quantity);
		return new ResponseEntity<PaintGunDTO>(dto,HttpStatus.ACCEPTED);
	}
}
