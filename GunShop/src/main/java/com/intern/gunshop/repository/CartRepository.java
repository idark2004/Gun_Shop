package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("SELECT c FROM Cart c INNER JOIN c.user u WHERE u.user_id = ?1")
	public Cart findByUserId(Integer user_id);
}
