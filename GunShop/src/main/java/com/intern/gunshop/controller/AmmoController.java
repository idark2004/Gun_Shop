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

import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.service.AmmoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ammo")
@Tag(name = "Ammo")
public class AmmoController {
	
	@Autowired
	private AmmoService service;
	
	@GetMapping
	public ResponseEntity<List<Ammo>> getAll(){		
		return new ResponseEntity<List<Ammo>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ammo> getOne(@PathVariable Integer id){
		return new ResponseEntity<Ammo>(service.getOne(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Ammo> addNew(@RequestBody Ammo ammo){
		return new ResponseEntity<Ammo>(service.addNew(ammo),HttpStatus.CREATED);
	}
	
}
