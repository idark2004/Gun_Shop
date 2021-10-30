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

import com.intern.gunshop.dto.CartRequestDTO;
import com.intern.gunshop.entity.Cart_Detail;
import com.intern.gunshop.service.CartDetailService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Detail")
public class CartDetailController {
	
	@Autowired
	private CartDetailService service;

	@PostMapping("/detail")
	public ResponseEntity<Cart_Detail> add(@RequestBody CartRequestDTO dto ){
		Cart_Detail detail = service.addDetail(dto.colored_id, dto.cart_id, dto.cart_quantity);
		return new ResponseEntity<Cart_Detail>(detail,HttpStatus.CREATED);
	}
	
	@GetMapping("/{cart_id}")
	public ResponseEntity<List<Cart_Detail>> getByCart(@PathVariable Integer cart_id){
		
		return new ResponseEntity<List<Cart_Detail>>(service.getCartDetail(cart_id),HttpStatus.OK);
	}
}
