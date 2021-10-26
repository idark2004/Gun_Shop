package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.repository.AmmoRepository;

@Service
public class AmmoService {
	
	@Autowired
	private AmmoRepository ammoRepo;
	
	public List<Ammo> getAll(){
		return ammoRepo.findAll();
	}
	
	public Ammo addNew(Ammo ammo) {
		return ammoRepo.save(ammo);
	}
	
	public Ammo getOne(Integer id) {
		return ammoRepo.findById(id).get();
	}
}
