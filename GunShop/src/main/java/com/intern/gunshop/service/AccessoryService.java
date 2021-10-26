package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.AccessoryRequest;
import com.intern.gunshop.entity.Accessory;
import com.intern.gunshop.entity.Category;
import com.intern.gunshop.repository.AccessoryRepository;
import com.intern.gunshop.repository.CategoryRepository;

@Service
public class AccessoryService {
	
	@Autowired
	private AccessoryRepository accessRepo;
	
	@Autowired
	private CategoryRepository cateRepo;
	
	public Accessory addNew(AccessoryRequest request) {
		Category cate = cateRepo.findById(request.category_id).get();
		Accessory access = new Accessory();
		access.setAccessory_name(request.accessory_name);
		access.setAccessory_quantity(request.accessory_quantity);
		access.setAccessory_price(request.accessory_price);
		access.setAccessory_description(request.accessory_description);
		access.setAdded_date(request.added_date);
		access.setModified_date(request.modified_date);
		access.setAccessory_status(true);
		access.setCategory(cate);
		
		return accessRepo.save(access);
	}
	
	public List<Accessory> getAll(){
		return accessRepo.findAll();
	}
	
	public Accessory getById(Integer id) {
		return accessRepo.findById(id).get();
	}
	
	public Accessory updateAccessory(Accessory access) {
		return accessRepo.save(access);
	}
}
