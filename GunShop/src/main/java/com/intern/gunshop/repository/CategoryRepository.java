package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
