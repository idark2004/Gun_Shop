package com.intern.gunshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.GunDTO;
import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.entity.Category;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.mapper.GunMapper;
import com.intern.gunshop.repository.AmmoRepository;
import com.intern.gunshop.repository.CategoryRepository;
import com.intern.gunshop.repository.GunRepository;
import com.intern.gunshop.request.GunRequest;
import com.intern.gunshop.util.GetTime;

@Service
public class GunService {

	@Autowired
	private GunRepository gunRepo;

	@Autowired
	private CategoryRepository cateRepo;

	@Autowired
	private AmmoRepository ammoRepo;

	@Autowired
	private GunMapper mapper;

	// create new gun
	public GunDTO addGun(GunRequest request) {
		Category cate = cateRepo.findById(request.getCategory_id()).get();

		Ammo ammo = ammoRepo.findById(request.getAmmo_id()).get();

		Gun newGun = mapper.requestToEntityCreate(request);

		newGun.setCategory(cate);
		newGun.setAmmo(ammo);
		newGun.setGun_status(true);
		newGun.setAdded_date(GetTime.getTimestamp());
		newGun.setModified_date(GetTime.getTimestamp());
		gunRepo.save(newGun);
		GunDTO dto = mapper.entityToDTO(newGun);
		dto.setAmmo_id(newGun.getAmmo().getAmmo_id());
		dto.setCategory_id(newGun.getCategory().getCategory_id());
		return dto;
	}

	//get all gun
	@Transactional
	public List<GunDTO> getAll() {
		List<GunDTO> dtoList = new ArrayList<GunDTO>();
		List<Gun> gunList = gunRepo.findAll();
		for (Gun gun : gunList) {
			GunDTO dto = mapper.entityToDTO(gun);			
			dto.setAmmo_id(gun.getAmmo().getAmmo_id());
			dto.setCategory_id(gun.getCategory().getCategory_id());
			dtoList.add(dto);
		}
		return dtoList;
	}

	//get gun by id
	public GunDTO getOne(Integer id) {
		GunDTO dto = new GunDTO();
		Gun gun = gunRepo.findById(id).get();
		dto = mapper.entityToDTO(gun);
		dto.setAmmo_id(gun.getAmmo().getAmmo_id());
		dto.setCategory_id(gun.getCategory().getCategory_id());
		return dto;
	}

}
