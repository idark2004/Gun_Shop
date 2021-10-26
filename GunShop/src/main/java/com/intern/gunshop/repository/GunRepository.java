package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Gun;

public interface GunRepository extends JpaRepository<Gun, Integer> {

}
