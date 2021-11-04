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

import com.intern.gunshop.entity.Color;
import com.intern.gunshop.service.ColorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/color")
@Tag(name = "Color")
public class ColorController {

	@Autowired
	private ColorService service;

	// add new color
	@Operation(summary = "Add new color", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@PostMapping
	public ResponseEntity<Color> add(@RequestBody String color_name) {
		return new ResponseEntity<Color>(service.addNew(color_name), HttpStatus.CREATED);
	}

	// get color list
	@Operation(summary = "Get all color", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@GetMapping
	public ResponseEntity<List<Color>> getAll() {
		return new ResponseEntity<List<Color>>(service.getAll(), HttpStatus.OK);
	}

	// change color's name
	@Operation(summary = "Change color's name", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = Color.class), mediaType = "application/json")) })
	@PutMapping("/{id}")
	public ResponseEntity<Color> changeName(@PathVariable Integer id, @RequestParam String name) {
		return new ResponseEntity<Color>(service.changeName(id, name), HttpStatus.ACCEPTED);
	}
}
