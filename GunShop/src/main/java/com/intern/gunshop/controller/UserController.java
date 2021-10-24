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

import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiException;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.pojos.UserRequest;
import com.intern.gunshop.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User")
public class UserController {

	@Autowired
	private UserService service;

	@Operation(summary = "Get all users", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Users.class), 
						mediaType = "application/json"), 
			description = "Return all user's information")})
	@GetMapping()
	public List<Users> list() {
		return service.getUserList();
	}

	
	@Operation(summary = "Get all users based on role Id", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Users.class), 
						mediaType = "application/json"), description = "Return all user's information"),			
			@ApiResponse(responseCode = "404" , description = "No users found with the inputed role id",
						content = @Content(schema = @Schema(implementation = ApiException.class), mediaType = "application/json"))})
	@GetMapping("/role/{role_id}")
	public ResponseEntity<List<Users>> getByRole(@PathVariable Integer role_id) {

		List<Users> users = service.getUserByRoleId(role_id);

		if (users.size() > 0) {			
			return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
		}
		throw new ApiRequestException("No user associate with role id: " + role_id, HttpStatus.NOT_FOUND);

	}

	@Operation(summary = "Create new user", responses = {
			@ApiResponse(responseCode = "201", content = 
						@Content(schema = @Schema(implementation = Users.class), 
						mediaType = "application/json"), 
			description = "Create new user and save to database successfully")})
	@PostMapping()
	public ResponseEntity<Users> add(@RequestBody UserRequest user) {
		Users newUser = service.addUser(user);
		return new ResponseEntity<Users>(newUser, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Update a user", responses = {
			@ApiResponse(responseCode = "202", content = 
						@Content(schema = @Schema(implementation = Users.class), 
						mediaType = "application/json"), 
			description = "Update user to database successfully")})
	@PutMapping("/{id}")
	public ResponseEntity<Users> update(@RequestBody Users user, @PathVariable Integer id) {
		if (service.getUser(id) != null) {
			user.setUser_id(id);
			Users updatedUser = service.updateUser(user);
			return new ResponseEntity<Users>(updatedUser, HttpStatus.ACCEPTED);
		}
		throw new ApiRequestException("Error at update method in UserController");
	}
	
	@Operation(summary = "Change user's status", responses = {
			@ApiResponse(responseCode = "202", content = 
						@Content(schema = @Schema(implementation = Users.class), 
						mediaType = "application/json"), 
			description = "User's status changed successfully")})
	@PutMapping("/{user_id}/{status}")
	public ResponseEntity<Users> changeState(@PathVariable(name = "user_id") Integer user_id,
												@PathVariable(name = "status") boolean status){
		Users updateUser = service.getUser(user_id);
		updateUser.setUser_status(status);
		service.updateUser(updateUser);
		return new ResponseEntity<Users>(updateUser,HttpStatus.ACCEPTED);
	}
}
