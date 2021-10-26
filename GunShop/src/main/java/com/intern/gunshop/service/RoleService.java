package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Role;
import com.intern.gunshop.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	public List<Role> listAll(){
		return repo.findAll();
	}
		
	
	public Role get(Integer id) {
		return repo.findById(id).get();
	}
}
