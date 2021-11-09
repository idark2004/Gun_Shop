package com.intern.gunshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.GunDTO;
import com.intern.gunshop.entity.Category;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.mapper.GunMapper;
import com.intern.gunshop.repository.CategoryRepository;
import com.intern.gunshop.repository.GunRepository;
import com.intern.gunshop.request.GunRequest;
import com.intern.gunshop.util.GetTime;
import com.intern.gunshop.util.Validator;

@Service
public class GunService {

	@Autowired
	private GunRepository gunRepo;

	@Autowired
	private CategoryRepository cateRepo;

	@Autowired
	private GunMapper mapper;

	// create new gun
	public GunDTO addGun(GunRequest request) {
		// Validate
		Validator.checkGunStringLengthCreate(request.getGun_name(), 2, "gun name");
		Validator.checkGunStringLengthCreate(request.getGun_description(), 3, "description");
		Validator.checkPositiveNumber(request.getCapacity());
		Validator.checkPositiveNumber(request.getGun_price());
		Validator.checkPositiveNumber((int) request.getWeight());

		// If all pass then start processing data
		Category cate = cateRepo.findById(request.getCategory_id()).get();

		Gun newGun = mapper.requestToEntityCreate(request);

		newGun.setCategory(cate);
		newGun.setGun_status(true);
		newGun.setAdded_date(GetTime.getTimestamp());
		newGun.setModified_date(GetTime.getTimestamp());
		gunRepo.save(newGun);
		GunDTO dto = mapper.entityToDTO(newGun);
		dto.setCategory_id(newGun.getCategory().getCategory_id());
		return dto;
	}

	// get all gun
	@Transactional
	public List<GunDTO> getAll() {
		List<GunDTO> dtoList = new ArrayList<GunDTO>();
		List<Gun> gunList = gunRepo.findAll();
		for (Gun gun : gunList) {
			GunDTO dto = mapper.entityToDTO(gun);
			dto.setCategory_id(gun.getCategory().getCategory_id());
			dtoList.add(dto);
		}
		return dtoList;
	}

	// get gun by id
	public GunDTO getOne(Integer id) {
		GunDTO dto = new GunDTO();
		Gun gun = gunRepo.findById(id).get();
		dto = mapper.entityToDTO(gun);
		dto.setCategory_id(gun.getCategory().getCategory_id());
		return dto;
	}

	// update existing gun
	public GunDTO update(GunRequest request, Integer id) {
		// Validate
		Validator.checkGunStringLengthUpdate(request.getGun_name(), 2, "gun name");
		Validator.checkGunStringLengthUpdate(request.getGun_description(), 3, "description");
		Validator.checkPositiveNumber(request.getCapacity());
		Validator.checkPositiveNumber(request.getGun_price());
		Validator.checkPositiveNumber((int) request.getWeight());

		// If all pass then start processing data
		Gun gun = gunRepo.findById(id).get();
		request.setCategory_id(gun.getCategory().getCategory_id());
		Gun updatedGun = mapper.requestToEntityUpdate(request, gun);
		updatedGun.setModified_date(GetTime.getTimestamp());
		gunRepo.save(updatedGun);
		GunDTO dto = mapper.entityToDTO(updatedGun);
		dto.setCategory_id(updatedGun.getCategory().getCategory_id());
		return dto;
	}

	// Change gun status
	public GunDTO changeStatus(Integer id) {
		Gun gun = gunRepo.findById(id).get();
		boolean current = gun.isGun_status();
		gun.setGun_status(!current);
		gun.setModified_date(GetTime.getTimestamp());
		gunRepo.save(gun);
		GunDTO dto = mapper.entityToDTO(gun);
		dto.setCategory_id(gun.getCategory().getCategory_id());
		return dto;
	}
}
