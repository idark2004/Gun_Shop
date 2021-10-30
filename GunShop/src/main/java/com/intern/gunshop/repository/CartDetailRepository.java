package com.intern.gunshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.intern.gunshop.entity.Cart_Detail;

public interface CartDetailRepository extends JpaRepository<Cart_Detail, Integer>{
	@Query("SELECT de FROM Cart_Detail de INNER JOIN de.cart c WHERE c.cart_id = ?1")
	public List<Cart_Detail> findByCartId(Integer cart_id);
}
