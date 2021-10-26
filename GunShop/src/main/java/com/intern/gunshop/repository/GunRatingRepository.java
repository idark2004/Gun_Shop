package com.intern.gunshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Gun_Rating;

public interface GunRatingRepository extends JpaRepository<Gun_Rating, Integer> {
	
	@Query("SELECT AVG(r.rated_point) FROM Gun_Rating r JOIN r.gun g WHERE g.gun_id = ?1")
	public String averageRateOfGun(Integer gun_id);
}
