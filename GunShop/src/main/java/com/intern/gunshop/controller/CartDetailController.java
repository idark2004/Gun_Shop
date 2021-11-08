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

import com.intern.gunshop.dto.CartDetailDTO;
import com.intern.gunshop.dto.CartRequestDTO;
import com.intern.gunshop.service.CartDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart Detail")
public class CartDetailController {
	
	@Autowired
	private CartDetailService service;

	//add item to cart
	@Operation(summary = "Add new item to cart", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CartDetailDTO.class), mediaType = "application/json")) })
	@PostMapping("/detail")
	public ResponseEntity<CartDetailDTO> add(@RequestBody CartRequestDTO dto ){
		CartDetailDTO detail = service.addDetail(dto.colored_id, dto.cart_id, dto.cart_quantity);
		return new ResponseEntity<CartDetailDTO>(detail,HttpStatus.CREATED);
	}
	
	//get all item in cart
	@Operation(summary = "get all items in cart", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CartDetailDTO.class), mediaType = "application/json")) })
	@GetMapping("/{cart_id}")
	public ResponseEntity<List<CartDetailDTO>> getByCart(@PathVariable Integer cart_id){
		
		return new ResponseEntity<List<CartDetailDTO>>(service.getCartDetail(cart_id),HttpStatus.OK);
	}
	
	//update cart quantity
	@Operation(summary = "update cart quantity", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CartDetailDTO.class), mediaType = "application/json")) })
	@PutMapping("/detail/{cde_id}")
	public ResponseEntity<CartDetailDTO> updateQuantity(@RequestParam int quantity, @PathVariable int cde_id){
		CartDetailDTO dto = service.updateQuantity(cde_id, quantity);
		return new ResponseEntity<CartDetailDTO>(dto,HttpStatus.OK);
	}
}
