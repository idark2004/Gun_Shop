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

import com.intern.gunshop.dto.AccessoryRequest;
import com.intern.gunshop.entity.Accessory;
import com.intern.gunshop.service.AccessoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/accessory")
@Tag(name = "Accessory")
public class AccessoryController {

	@Autowired
	private AccessoryService service;
	
	@PostMapping
	public ResponseEntity<Accessory> add(@RequestBody AccessoryRequest request){
		Accessory newAccess = service.addNew(request);
		return new ResponseEntity<Accessory>(newAccess,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Accessory>> getList(){
		return new ResponseEntity<List<Accessory>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Accessory> getOne(@PathVariable Integer id){
		return new ResponseEntity<Accessory>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Accessory> update(@RequestBody Accessory access, @PathVariable Integer id){
		access.setAccessory_id(id);
		Accessory newAccess = service.updateAccessory(access);
		return new ResponseEntity<Accessory>(newAccess,HttpStatus.ACCEPTED);
	}
	
}
