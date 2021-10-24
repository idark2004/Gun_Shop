package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Gun {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gun_id;
	private int capacity;
	private int weight;
	private String gun_description;
	private String gun_image;
	private boolean gun_status;
	private int gun_price;

	@OneToMany(mappedBy = "gun")	
	private Set<Gun_Rating> gun_rating;
	
	public Gun() {

	}

	public int getGun_id() {
		return gun_id;
	}

	public void setGun_id(int gun_id) {
		this.gun_id = gun_id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGun_description() {
		return gun_description;
	}

	public void setGun_description(String gun_description) {
		this.gun_description = gun_description;
	}

	public String getGun_image() {
		return gun_image;
	}

	public void setGun_image(String gun_image) {
		this.gun_image = gun_image;
	}

	public boolean isGun_status() {
		return gun_status;
	}

	public void setGun_status(boolean gun_status) {
		this.gun_status = gun_status;
	}

	public int getGun_price() {
		return gun_price;
	}

	public void setGun_price(int gun_price) {
		this.gun_price = gun_price;
	}

	@JsonIgnore
	public Set<Gun_Rating> getGun_rating() {
		return gun_rating;
	}

	public void setGun_rating(Set<Gun_Rating> gun_rating) {
		this.gun_rating = gun_rating;
	}

	
}
