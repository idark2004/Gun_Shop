package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("SELECT r FROM Role r WHERE r.role_name LIKE ?1")
	Role findByRole_name(String role_name);
}
