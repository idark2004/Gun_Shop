package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.gunshop.entity.Gun_Rating;
import com.intern.gunshop.entity.Gun_Rating_Id;

public interface GunRatingRepository extends JpaRepository<Gun_Rating, Gun_Rating_Id> {

}
