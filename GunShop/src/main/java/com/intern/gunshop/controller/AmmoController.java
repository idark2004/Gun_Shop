package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.AmmoDTO;
import com.intern.gunshop.dto.UserDTO;
import com.intern.gunshop.request.AmmoRequest;
import com.intern.gunshop.service.AmmoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ammo")
@Tag(name = "Ammo")
public class AmmoController {

	@Autowired
	private AmmoService service;

	// Get all ammo
	@Operation(summary = "Get all ammo", responses = {
			@ApiResponse(responseCode = "200", 
					content = @Content(schema = @Schema(implementation = UserDTO.class), 
					mediaType = "application/json"), description = "Return all ammo's information") })
	@GetMapping
	public ResponseEntity<List<AmmoDTO>> getAll() {
		return new ResponseEntity<List<AmmoDTO>>(service.getAll(), HttpStatus.OK);
	}

	@Operation(summary = "Get ammo by ammo id", responses = {
			@ApiResponse(responseCode = "200", 
					content = @Content(schema = @Schema(implementation = UserDTO.class), 
					mediaType = "application/json"), description = "Return all ammo's information") })
	@GetMapping("/{id}")
	public ResponseEntity<AmmoDTO> getOne(@PathVariable Integer id) {
		return new ResponseEntity<AmmoDTO>(service.getOne(id), HttpStatus.OK);
	}

	@Operation(summary = "Add new ammo", responses = {
			@ApiResponse(responseCode = "201", 
					content = @Content(schema = @Schema(implementation = UserDTO.class), 
					mediaType = "application/json"), description = "Created new ammo successfully") })
	@PostMapping
	public ResponseEntity<AmmoDTO> addNew(@RequestBody AmmoRequest request) {
		return new ResponseEntity<AmmoDTO>(service.addNew(request), HttpStatus.CREATED);
	}

}
