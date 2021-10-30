package com.intern.gunshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.entity.Cart;
import com.intern.gunshop.service.CartService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart")
public class CartController {
	
	@Autowired
	private CartService service;
	
	@PostMapping("/{user_id}")
	public ResponseEntity<Cart> add(@PathVariable Integer user_id){
		return new ResponseEntity<Cart>(service.addCart(user_id),HttpStatus.CREATED);
	}
		
}
