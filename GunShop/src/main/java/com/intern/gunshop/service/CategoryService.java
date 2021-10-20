package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Category;
import com.intern.gunshop.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> getAll(){
		return repo.findAll();
	}
	
	public Category get(Integer id) { 
		return repo.findById(id).get();
	}
	
	public Category addNew(Category category) {
		return repo.save(category);
	}
}
