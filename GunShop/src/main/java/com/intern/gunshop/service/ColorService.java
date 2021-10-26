package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Color;
import com.intern.gunshop.repository.ColorRepository;

@Service
public class ColorService {

	@Autowired
	private ColorRepository repo;
	
	public Color addNew(Color color) {
		return repo.save(color);
	}
	
	public List<Color> getAll(){
		return repo.findAll();
	}
	
	public Color getById(Integer id) {
		return repo.findById(id).get();
	}
}
