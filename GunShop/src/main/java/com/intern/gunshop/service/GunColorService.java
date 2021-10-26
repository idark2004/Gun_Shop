package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.PaintGunDTO;
import com.intern.gunshop.entity.Color;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.repository.ColorRepository;
import com.intern.gunshop.repository.GunColorRepository;
import com.intern.gunshop.repository.GunRepository;

@Service
public class GunColorService {

	@Autowired
	private GunRepository gunRepo;
	
	@Autowired
	private GunColorRepository paintRepo;
	
	@Autowired
	private ColorRepository colorRepo;
	
	//Bind color, gun and quantity
	public Gun_Color paintGun(PaintGunDTO dto) {
		Gun gun = gunRepo.findById(dto.gun_id).get();
		Color color = colorRepo.findById(dto.color_id).get();
		Gun_Color gunColor = new Gun_Color();
		gunColor.setColor(color);
		gunColor.setColored_gun(gun);
		gunColor.setQuantity(dto.quantity);
		
		return paintRepo.save(gunColor);		
	}
		
	public List<Color> getColor(Integer gun_id){
		
		return paintRepo.getColorByGunId(gun_id);
	}	
}
