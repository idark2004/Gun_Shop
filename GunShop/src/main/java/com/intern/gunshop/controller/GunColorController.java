package com.intern.gunshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.gunshop.dto.PaintGunDTO;
import com.intern.gunshop.entity.Color;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.service.GunColorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/paint")
@Tag(name = "Gun's Paint")
public class GunColorController {
	
	@Autowired
	private GunColorService service;
	
	@PostMapping()
	public ResponseEntity<Gun_Color> addPain(@RequestBody PaintGunDTO dto){
		return new ResponseEntity<Gun_Color>(service.paintGun(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{gun_id}")
	public ResponseEntity<List<Color>> getColorByGun(@PathVariable Integer gun_id){
		return new ResponseEntity<List<Color>>(service.getColor(gun_id),HttpStatus.OK);
	}
}
