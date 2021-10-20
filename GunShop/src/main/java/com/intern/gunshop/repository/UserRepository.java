package com.intern.gunshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u FROM Role r JOIN r.users u WHERE r.role_id = ?1")
	public List<Users> getByRoleId(Integer role_id);
}
