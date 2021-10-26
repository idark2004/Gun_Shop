package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.entity.Color;
import com.intern.gunshop.service.ColorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/color")
@Tag(name = "Color")
public class ColorController {

	@Autowired
	private ColorService service;
	
	
	@PostMapping
	public ResponseEntity<Color> add(@RequestBody Color color){
		return new ResponseEntity<Color>(service.addNew(color),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Color>> getAll(){
		return new ResponseEntity<List<Color>>(service.getAll(),HttpStatus.OK);
	}
}
