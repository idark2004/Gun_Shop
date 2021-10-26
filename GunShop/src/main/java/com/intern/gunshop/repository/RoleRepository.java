package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
		
}
