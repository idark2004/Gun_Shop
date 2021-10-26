package com.intern.gunshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.entity.Role;
import com.intern.gunshop.service.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/role")
@Tag(name = "Role")
public class RoleController {

	@Autowired
	private RoleService service;

	@Operation(summary = "Get all roles", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Role.class), 
						mediaType = "application/json"))})
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Role> list() {
		return service.listAll();
	}

	@Operation(summary = "Get role by id", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Role.class), 
						mediaType = "application/json"))})
	@GetMapping("/{id}")
	public ResponseEntity<Role> get(@PathVariable Integer id) {
		Role role = service.get(id);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
}
