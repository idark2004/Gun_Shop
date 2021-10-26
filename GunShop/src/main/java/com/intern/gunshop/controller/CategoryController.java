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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.entity.Category;
import com.intern.gunshop.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@Operation(summary = "Get all category", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Category.class), 
						mediaType = "application/json"))})
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Category> getList(){
		return service.getAll();
	}
	
	@Operation(summary = "Get a category by id", responses = {
			@ApiResponse(responseCode = "200", content = 
						@Content(schema = @Schema(implementation = Category.class), 
						mediaType = "application/json"))})
	@GetMapping("/{id}")
	public ResponseEntity<Category> get(@PathVariable Integer id) {		
		Category category = service.get(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);				
	}
	
	@Operation(summary = "Create new category", responses = {
			@ApiResponse(responseCode = "201", content = 
						@Content(schema = @Schema(implementation = Category.class), 
						mediaType = "application/json"))})
	@PostMapping()
	public ResponseEntity<Category> add(@RequestBody Category category) {
		Category newCategory = service.addNew(category);
		return new ResponseEntity<Category>(newCategory,HttpStatus.CREATED);
	}
}
