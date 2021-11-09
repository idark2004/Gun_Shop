package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.OrderDetailDTO;
import com.intern.gunshop.service.OrderDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/order-detail")
@Tag(name = "Order Detail")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService service;
	
	//Transfer item in cart to order
	@Operation(summary = "Transfer item in cart to order", responses = {
			@ApiResponse(responseCode = "201", content = 
						@Content(schema = @Schema(implementation = OrderDetailDTO.class), 
						mediaType = "application/json"))})
	@PostMapping
	public ResponseEntity<List<OrderDetailDTO>> add(@RequestParam Integer user_id, @RequestParam Integer order_id){
		List<OrderDetailDTO> dtoList = service.addAll(user_id, order_id);
		return new ResponseEntity<List<OrderDetailDTO>>(dtoList,HttpStatus.CREATED);
	}
}
