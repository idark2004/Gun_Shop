package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.AmmoDTO;
import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.mapper.AmmoMapper;
import com.intern.gunshop.repository.AmmoRepository;
import com.intern.gunshop.request.AmmoRequest;
import com.intern.gunshop.util.GetTime;

@Service
public class AmmoService {

	@Autowired
	private AmmoRepository ammoRepo;

	@Autowired
	private AmmoMapper mapper;

	// Get ammo list
	public List<AmmoDTO> getAll() {
		List<Ammo> ammoList = ammoRepo.findAll();
		List<AmmoDTO> dtoList = new ArrayList<AmmoDTO>();
		for (Ammo ammo : ammoList) {
			AmmoDTO dto = mapper.entityToDTO(ammo);
			dtoList.add(dto);
		}
		return dtoList;
	}

	// add new ammo
	public AmmoDTO addNew(AmmoRequest request) {
		Ammo ammo = mapper.requestToEntityCreate(request);
		LocalDate date = LocalDate.now();
		LocalDateTime now = LocalDateTime.now();
		Timestamp added_date = Timestamp.valueOf(now);
		ammo.setAdded_date(date);
		ammo.setModified_date(added_date);
		ammo.setAmmo_status(true);
		ammoRepo.save(ammo);
		AmmoDTO dto = mapper.entityToDTO(ammo);
		return dto;
	}

	// get ammo by ammo id
	public AmmoDTO getOne(Integer id) {
		Ammo ammo = ammoRepo.findById(id).get();
		AmmoDTO dto = mapper.entityToDTO(ammo);
		return dto;
	}

	// update ammo
	public AmmoDTO updateAmmo(AmmoRequest request, Integer id) {
		Ammo savedAmmo = ammoRepo.findById(id).get();
		savedAmmo = mapper.requestToEntityUpdate(request, savedAmmo);
		savedAmmo.setModified_date(GetTime.getTimestamp());
		ammoRepo.save(savedAmmo);
		return mapper.entityToDTO(savedAmmo);
	}
	
	// change ammo's status
	@Transactional
	public AmmoDTO changeStatus(Integer id) {
		Ammo ammo = ammoRepo.findById(id).get();
		boolean current = ammo.isAmmo_status();
		ammo.setAmmo_status(!current);
		AmmoDTO dto = mapper.entityToDTO(ammo);
		return dto;
	}
}
