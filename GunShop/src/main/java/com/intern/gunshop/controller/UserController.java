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

import com.intern.gunshop.dto.UserDTO;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiException;
import com.intern.gunshop.request.UserRequest;
import com.intern.gunshop.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User")
public class UserController {

	@Autowired
	private UserService service;


	// Get List User
	@Operation(summary = "Get all users", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserDTO.class), mediaType = "application/json"), description = "Return all user's information") })
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> list() {
		return new ResponseEntity<List<UserDTO>>(service.getUserList(),HttpStatus.OK);
	}

	// Get user by Role Id
	@Operation(summary = "Get all users based on role Id", responses = {
			@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserDTO.class), mediaType = "application/json"), description = "Return all user's information"),
			@ApiResponse(responseCode = "404", description = "No users found with the inputed role id", content = @Content(schema = @Schema(implementation = ApiException.class), mediaType = "application/json")) })
	@GetMapping("/role/{role_id}")
	public ResponseEntity<List<UserDTO>> getByRole(@PathVariable Integer role_id) {

		List<UserDTO> users = service.getUserByRoleId(role_id);

		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);

	}

	// Add new User
	@Operation(summary = "Create new user", responses = {
			@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = UserDTO.class), mediaType = "application/json"), description = "Create new user and save to database successfully") })
	@PostMapping("/save")
	public ResponseEntity<UserDTO> add(@RequestBody UserRequest user) {
		UserDTO dto = service.addUser(user);
		
		return new ResponseEntity<UserDTO>(dto, HttpStatus.CREATED);
	}

	//update existing user
	@Operation(summary = "Update a user", responses = {
			@ApiResponse(responseCode = "202", content = @Content(schema = @Schema(implementation = UserRequest.class), mediaType = "application/json"), description = "Update user to database successfully") })
	@PutMapping("/{id}")
	public ResponseEntity<UserRequest> update(@RequestBody UserRequest request, @PathVariable Integer id) {			
			UserRequest updatedUser = service.updateUser(request,id);
			return new ResponseEntity<UserRequest>(updatedUser, HttpStatus.ACCEPTED);		
	}

	
	//change user's status
	@Operation(summary = "Change user's status", responses = {
			@ApiResponse(responseCode = "202", content = 
						@Content(schema = @Schema(implementation = UserDTO.class), 
						mediaType = "application/json"), 
			description = "User's status changed successfully")})
	@PutMapping("/{user_id}/status")
	public ResponseEntity<UserDTO> changeState(@PathVariable(name = "user_id") Integer user_id){
		UserDTO updateUser = service.changeState(user_id);
		return new ResponseEntity<UserDTO>(updateUser,HttpStatus.ACCEPTED);
	}

	
	//get a user by user id
	@Operation(summary = "Get a user by id", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = UserDTO.class), 
						mediaType = "application/json"))})
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Integer id) {
		return service.getUser(id);
	}
	
	//add role to user
	@Operation(summary = "Add role to user", responses = {
			@ApiResponse(responseCode = "202", content = 
						@Content(schema = @Schema(implementation = UserDTO.class), 
						mediaType = "application/json"), 
			description = "User's role changed successfully")})
	@PutMapping("/changed-role/{id}/{roleName}")
	public ResponseEntity<UserDTO> changeRole(@PathVariable Integer id,
												@PathVariable String roleName){
		return new ResponseEntity<UserDTO>(service.addRoleToUser(id, roleName),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/email/{email}")
	public Users getByEmail(@PathVariable String email) {
		return service.getByEmail(email);
	}
}
