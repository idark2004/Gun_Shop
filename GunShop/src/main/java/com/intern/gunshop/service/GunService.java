package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.GunRequest;
import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.entity.Category;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.repository.AmmoRepository;
import com.intern.gunshop.repository.CategoryRepository;
import com.intern.gunshop.repository.GunRepository;

@Service
public class GunService {
	
	@Autowired
	private GunRepository gunRepo;
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private AmmoRepository ammoRepo;
	
	public Gun addGun(GunRequest request) {
		Category cate = cateRepo.findById(request.category_id).get();
		
		Ammo ammo = ammoRepo.findById(request.ammo_id).get();		
		
		Gun newGun = new Gun();
		
		LocalDateTime now = LocalDateTime.now();
		Timestamp date = Timestamp.valueOf(now);
		newGun.setAmmo(ammo);
		newGun.setCategory(cate);
		newGun.setCapacity(request.capacity);
		newGun.setGun_description(request.gun_description);
		newGun.setGun_image(request.gun_image);
		newGun.setGun_price(request.gun_price);
		newGun.setGun_status(true);
		newGun.setWeight(request.weight);
		newGun.setAdded_date(date);
		newGun.setModified_date(date);
		
		return gunRepo.save(newGun);
	}
	
	public List<Gun> getAll(){
		return gunRepo.findAll();
	}
	
	public Gun getOne(Integer id) {
		return gunRepo.findById(id).get();
	}
}
