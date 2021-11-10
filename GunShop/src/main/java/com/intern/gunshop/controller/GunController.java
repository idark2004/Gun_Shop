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
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.GunDTO;
import com.intern.gunshop.request.GunRequest;
import com.intern.gunshop.service.GunService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/gun")
@Tag(name = "Gun")
public class GunController {
	
	@Autowired
	private GunService service;
	
	//add new gun
	@Operation(summary = "Add new gun", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = GunDTO.class), mediaType = "application/json")) })
	@PostMapping
	public ResponseEntity<GunDTO> add(@RequestBody GunRequest request){
		return new ResponseEntity<GunDTO>(service.addGun(request),HttpStatus.CREATED);
	}
	
	//get gun list
	@Operation(summary = "Get all gun", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GunDTO.class), mediaType = "application/json")) })
	@GetMapping
	public ResponseEntity<List<GunDTO>> getAll(){
		return new ResponseEntity<List<GunDTO>>(service.getAll(),HttpStatus.OK);
	}
	
	//get gun by id
	@Operation(summary = "Get gun by id", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GunDTO.class), mediaType = "application/json")) })
	@GetMapping("/{id}")
	public ResponseEntity<GunDTO> getById(@PathVariable Integer id){
		return new ResponseEntity<GunDTO>(service.getOne(id),HttpStatus.OK);
	}
	
	//update existing gun
	@Operation(summary = "Update existing gun", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = GunDTO.class), mediaType = "application/json")) })
	@PutMapping("/updated-gun/{id}")
	public ResponseEntity<GunDTO> update(@RequestBody GunRequest request, @PathVariable Integer id){
		GunDTO dto = service.update(request, id);
		return new ResponseEntity<GunDTO>(dto,HttpStatus.ACCEPTED);
	}
	
	//Change gun status
	@Operation(summary = "Change gun status", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = GunDTO.class), mediaType = "application/json")) })
	@PutMapping("/status/{id}")
	public ResponseEntity<GunDTO> changeStatus(@PathVariable Integer id){
		GunDTO dto = service.changeStatus(id);
		return new ResponseEntity<GunDTO>(dto,HttpStatus.ACCEPTED);
	}
}
