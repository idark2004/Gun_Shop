package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {

}
