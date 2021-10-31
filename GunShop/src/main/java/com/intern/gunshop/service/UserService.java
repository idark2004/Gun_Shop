package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.UserDTO;
import com.intern.gunshop.entity.Role;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.mapper.UserMapper;
import com.intern.gunshop.repository.RoleRepository;
import com.intern.gunshop.repository.UserRepository;
import com.intern.gunshop.request.UserRequest;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = repo.findByEmail(email);
		if (user == null) {
			throw new ApiRequestException("No such user with email!", HttpStatus.NOT_FOUND);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		user.getRoles().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
		});
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPass_word(),
				authorities);
	}

	// get all user
	public List<UserDTO> getUserList() {
		List<Users> userList = repo.findAll();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for (Users user : userList) {
			UserDTO dto = mapper.entityToDto(user);
			addRoleNameToDTO(user, dto);
		}
		return dtoList;
	}

	// add a new user
	public UserDTO addUser(UserRequest user) {
		LocalDateTime now = LocalDateTime.now();
		Timestamp created_date = Timestamp.valueOf(now);
		Role role = roleRepo.findById(2).get();
		Users newUser = new Users();
		newUser.setUser_name(user.user_name);
		newUser.setEmail(user.email);
		newUser.setPass_word(passwordEncoder.encode(user.pass_word));
		newUser.setBirth_date(user.birth_date);
		newUser.setCreated_date(created_date);
		newUser.setUser_status(true);
		newUser.getRoles().add(role);
		newUser = repo.save(newUser);
		UserDTO dto = mapper.entityToDto(newUser);
		addRoleNameToDTO(newUser, dto);
		dto.setUser_id(newUser.getUser_id());
		return dto;
	}

	// update an existing user
	public UserRequest updateUser(UserRequest request, Integer user_id) {
		Users savedUser = repo.findById(user_id).get();
		savedUser = mapper.requestToEntity(request, savedUser);
		repo.save(savedUser);
		request = mapper.entityToRequest(savedUser);
		return request;
	}

	// get a user based on role id
	public List<UserDTO> getUserByRoleId(Integer role_id) {
		List<Users> userList = repo.getByRoleId(role_id);
		if (userList.size() < 1) {
			throw new ApiRequestException("No users with role Id : " + role_id, HttpStatus.BAD_REQUEST);
		}
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for (Users user : userList) {
			UserDTO dto = mapper.entityToDto(user);
			dto.setUser_id(user.getUser_id());
			addRoleNameToDTO(user, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	// get user based on user id
	public UserDTO getUser(Integer user_id) {
		Users user = repo.findById(user_id).get();
		UserDTO dto = mapper.entityToDto(user);
		addRoleNameToDTO(user, dto);
		return dto;
	}

	// change user's status
	public UserDTO changeState(Integer user_id) {
		Users user = repo.findById(user_id).get();
		boolean newState = !user.isUser_status();
		user.setUser_status(newState);
		repo.save(user);
		UserDTO dto = mapper.entityToDto(user);
		addRoleNameToDTO(user, dto);
		return dto;

	}

	// Add user's role
	public UserDTO addRoleToUser(Integer user_id, String role_name) {
		Users user = repo.findById(user_id).get();
		Role role = roleRepo.findByRole_name(role_name);
		user.getRoles().add(role);
		repo.save(user);
		UserDTO dto = mapper.entityToDto(user);
		addRoleNameToDTO(user, dto);
		return dto;
	}
	
	//Get user by email
	public Users getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	// mapping role_name from entity to dto
	public void addRoleNameToDTO(Users user, UserDTO dto){
		user.getRoles().forEach(role ->{
			dto.getRole_name().add(role.getRole_name());
		});
	}

}
