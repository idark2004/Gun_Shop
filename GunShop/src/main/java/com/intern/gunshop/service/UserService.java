package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.UserRequest;
import com.intern.gunshop.entity.Role;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.repository.RoleRepository;
import com.intern.gunshop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public List<Users> getUserList(){
		return repo.findAll();
	}
	
	public Users addUser(UserRequest user) {
		Role role = roleRepo.findById(2).get();
		Users newUser = new Users();
		newUser.setUser_name(user.user_name);
		newUser.setEmail(user.email);
		newUser.setPass_word(user.pass_word);
		newUser.setBirth_date(user.birth_date);
		newUser.setCreated_date(user.created_date);
		newUser.setUser_status(user.user_status);
		newUser.setRole(role);
		
		return repo.save(newUser);
	}
	
	public Users updateUser(Users user) {
		return repo.save(user);
	}
	
	public List<Users> getUserByRoleId(Integer role_id){
		return repo.getByRoleId(role_id);
	}
	
	public Users getUser(Integer user_id) {
		return repo.findById(user_id).get();
	}
}
