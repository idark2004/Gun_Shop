package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Ammo;

public interface AmmoRepository extends JpaRepository<Ammo, Integer> {

}
