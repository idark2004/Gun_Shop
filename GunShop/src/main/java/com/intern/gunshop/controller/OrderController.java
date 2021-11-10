package com.intern.gunshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.OrderDTO;
import com.intern.gunshop.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/order")
@Tag(name = "Order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	//Create an order
	@Operation(summary = "Create new order", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = OrderDTO.class), mediaType = "application/json")) })
	@PostMapping()
	public ResponseEntity<OrderDTO> create(@RequestParam Integer user_id){
		OrderDTO dto = service.createOrder(user_id);
		return new ResponseEntity<OrderDTO>(dto,HttpStatus.CREATED);
	}
	
	//Change order status
	@Operation(summary = "Change order status", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = OrderDTO.class), mediaType = "application/json")) })
	@PutMapping("/{order_id}")
	public ResponseEntity<OrderDTO> changeStatus(@PathVariable Integer order_id, @RequestParam String status){
		OrderDTO dto = service.changeStatus(order_id, status);
		return new ResponseEntity<OrderDTO>(dto,HttpStatus.ACCEPTED);
	}
}
