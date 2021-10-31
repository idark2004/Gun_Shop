package com.intern.gunshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u FROM Role r JOIN r.users u WHERE r.role_id = ?1")
	public List<Users> getByRoleId(Integer role_id);

	@Query("SELECT u FROM Users u WHERE u.user_name LIKE ?1")
	public Users findByUserName(String username);
	
	//@Query("SELECT u FROM Users u WHERE u.email LIKE ?1")
	public Users findByEmail(String email);
}
