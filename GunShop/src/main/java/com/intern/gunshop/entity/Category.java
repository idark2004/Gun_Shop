package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
	private String category_name;
	private String category_description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Accessory> accessory_list;

	@OneToMany(mappedBy = "category")
	private Set<Gun> gun_list;

	public Category() {
	}

	public Category(String category_name, String category_description) {
		this.category_name = category_name;
		this.category_description = category_description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	@JsonIgnore
	public Set<Accessory> getAccessory_list() {
		return accessory_list;
	}

	public void setAccessory_list(Set<Accessory> accessory_list) {
		this.accessory_list = accessory_list;
	}

	@JsonIgnore
	public Set<Gun> getGuns() {
		return gun_list;
	}

	public void setGuns(Set<Gun> gun_list) {
		this.gun_list = gun_list;
	}

}
