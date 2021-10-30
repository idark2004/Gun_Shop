package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
