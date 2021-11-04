package com.intern.gunshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Color;
import com.intern.gunshop.repository.ColorRepository;

@Service
public class ColorService {

	@Autowired
	private ColorRepository repo;
	
	public Color addNew(String color_name) {
		Color newColor = new Color();
		newColor.setColor_name(color_name);
		return repo.save(newColor);
	}
	
	public List<Color> getAll(){
		return repo.findAll();
	}
	
	public Color getById(Integer id) {
		return repo.findById(id).get();
	}
	
	@Transactional
	public Color changeName(Integer id, String color_name) {
		Color color = repo.findById(id).get();
		color.setColor_name(color_name);
		return color;
	}
}
