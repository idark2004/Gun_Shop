package com.intern.gunshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.gunshop.entity.Color;
import com.intern.gunshop.entity.Gun_Color;

public interface GunColorRepository extends JpaRepository<Gun_Color, Integer> {

	@Query("SELECT c.color FROM Gun_Color c INNER JOIN c.colored_gun g WHERE g.gun_id = ?1")
	public List<Color> getColorByGunId(Integer id);
	
}
