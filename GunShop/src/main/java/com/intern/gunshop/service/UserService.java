package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.UserRequest;
import com.intern.gunshop.entity.Role;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.mapper.UserMapper;
import com.intern.gunshop.repository.RoleRepository;
import com.intern.gunshop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserMapper mapper;

	public List<UserDTO> getUserList() {
		List<Users> userList = repo.findAll();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for(Users user : userList) {
			UserDTO dto = mapper.entityToDto(user);
			dto.setRole_name(user.getRole().getRole_name());
			dtoList.add(dto);
		}
		return dtoList;
	}

	//add a new user
	public Users addUser(UserRequest user) {
		LocalDateTime now = LocalDateTime.now();
		Timestamp created_date = Timestamp.valueOf(now);
		Role role = roleRepo.findById(2).get();
		Users newUser = new Users();
		newUser.setUser_name(user.user_name);
		newUser.setEmail(user.email);
		newUser.setPass_word(user.pass_word);
		newUser.setBirth_date(user.birth_date);
		newUser.setCreated_date(created_date);
		newUser.setUser_status(true);
		newUser.setRole(role);

		return repo.save(newUser);
	}

	// update an existing user
	public UserRequest updateUser(UserRequest request, Integer user_id) {
		Users savedUser = repo.findById(user_id).get();
		savedUser = mapper.requestToEntity(request, savedUser);	
		repo.save(savedUser);
		request = mapper.entityToRequest(savedUser);
		return request;
	}

	
	//get a user based on role id
	public List<UserDTO> getUserByRoleId(Integer role_id) {
		List<Users> userList = repo.getByRoleId(role_id);
		if(userList.size() < 1) {
			throw new ApiRequestException("No users with role Id : " + role_id, HttpStatus.BAD_REQUEST);
		}
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for(Users user : userList) {
			UserDTO dto = mapper.entityToDto(user);
			dto.setUser_id(user.getUser_id());
			dto.setRole_name(user.getRole().getRole_name());
			dtoList.add(dto);
		}
		return dtoList;
	}

	// get user based on user id 
	public UserDTO getUser(Integer user_id) {
		Users user = repo.findById(user_id).get();
		UserDTO dto = mapper.entityToDto(user);
		dto.setRole_name(user.getRole().getRole_name());
		return dto;
	}
	
	// change user's status
	
	public UserDTO changeState(Integer user_id) {
		Users user = repo.findById(user_id).get();
		boolean newState = !user.isUser_status();
		user.setUser_status(newState);
		repo.save(user);
		UserDTO dto = mapper.entityToDto(user);
		dto.setRole_name(user.getRole().getRole_name());
		return dto;
		
	}
}
