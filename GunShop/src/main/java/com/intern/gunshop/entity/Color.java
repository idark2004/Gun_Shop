package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int color_id;
	
	private String color_name;
	
	@OneToMany(mappedBy = "color")
	private Set<Gun_Color> gun_list;
	
	public Color() {}

	public int getColor_id() {
		return color_id;
	}

	public void setColor_id(int color_id) {
		this.color_id = color_id;
	}

	public String getColor_name() {
		return color_name;
	}

	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}

	@JsonIgnore
	public Set<Gun_Color> getGun_list() {
		return gun_list;
	}

	public void setGun_list(Set<Gun_Color> gun_list) {
		this.gun_list = gun_list;
	}
		
}
