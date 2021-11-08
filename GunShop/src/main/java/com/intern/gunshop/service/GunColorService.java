package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.PaintGunDTO;
import com.intern.gunshop.entity.Color;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.repository.ColorRepository;
import com.intern.gunshop.repository.GunColorRepository;
import com.intern.gunshop.repository.GunRepository;
import com.intern.gunshop.request.PaintGunRequest;
import com.intern.gunshop.util.Validator;

@Service
public class GunColorService {

	@Autowired
	private GunRepository gunRepo;
	
	@Autowired
	private GunColorRepository paintRepo;
	
	@Autowired
	private ColorRepository colorRepo;
	
	//Bind color, gun and quantity
	public PaintGunDTO paintGun(PaintGunRequest request) {
		Color color = colorRepo.findById(request.getColor_id()).get();
		//Validate
		Validator.checkPositiveNumber(request.getQuantity());
		
		List<Color> list = paintRepo.getColorByGunId(request.getGun_id());
		if(list != null) {
			for(Color c : list) {
				if(c.getColor_name().equals(color.getColor_name())) {
					throw new ApiRequestException("This gun already has the color : " + c.getColor_name());
				}
			}
		}
		Gun gun = gunRepo.findById(request.getGun_id()).get();
		
		Gun_Color gunColor = new Gun_Color();
		gunColor.setColor(color);
		gunColor.setColored_gun(gun);
		gunColor.setQuantity(request.getQuantity());
		gunColor.set_having(true);
		paintRepo.save(gunColor);
		PaintGunDTO dto = new PaintGunDTO();
		dto.setColor_name(color.getColor_name());
		dto.setGun_name(gun.getGun_name());
		dto.setQuantity(request.getQuantity());
		dto.set_having(gunColor.is_having());
		return dto; 		
	}
		
	//Get all gun color
	public List<Color> getColor(Integer gun_id){
		
		return paintRepo.getColorByGunId(gun_id);
	}
	
	//Change status
	public PaintGunDTO changeStatus(Integer id) {
		Gun_Color gunColor = paintRepo.findById(id).get();
		boolean cur = gunColor.is_having();
		gunColor.set_having(!cur);
		paintRepo.save(gunColor);
		PaintGunDTO dto = new PaintGunDTO();
		dto.set_having(!cur);
		dto.setColor_name(gunColor.getColor().getColor_name());
		dto.setGun_name(gunColor.getColored_gun().getGun_name());
		dto.setQuantity(gunColor.getQuantity());
		return dto;
	}
	
	//Update gun color quantity
	public PaintGunDTO updateQuantity(Integer id, int quantity) {
		Validator.checkPositiveNumber(quantity);
		Gun_Color gunColor = paintRepo.findById(id).get();
		gunColor.setQuantity(quantity);
		paintRepo.save(gunColor);
		PaintGunDTO dto = new PaintGunDTO();
		dto.set_having(gunColor.is_having());
		dto.setColor_name(gunColor.getColor().getColor_name());
		dto.setGun_name(gunColor.getColored_gun().getGun_name());
		dto.setQuantity(gunColor.getQuantity());
		return dto;
	}
}
