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

import com.intern.gunshop.dto.GunRequest;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.service.GunService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gun")
@Tag(name = "Gun")
public class GunController {
	
	@Autowired
	private GunService service;
	
	@PostMapping
	public ResponseEntity<Gun> add(@RequestBody GunRequest request){
		return new ResponseEntity<Gun>(service.addGun(request),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Gun>> getAll(){
		return new ResponseEntity<List<Gun>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gun> getById(@PathVariable Integer id){
		return new ResponseEntity<Gun>(service.getOne(id),HttpStatus.OK);
	}
}
