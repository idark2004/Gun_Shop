package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
