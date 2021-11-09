package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Order_Detail;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{

}
