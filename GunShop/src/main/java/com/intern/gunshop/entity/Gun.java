package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Gun {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gun_id;
	private int capacity;
	private double weight;
	private String gun_description;
	private String gun_image;
	private boolean gun_status;
	private int gun_price;
	private Timestamp added_date;
	private Timestamp modified_date;

	@OneToMany(mappedBy = "gun")
	private Set<Gun_Rating> gun_rating;
	
	@OneToMany(mappedBy = "colored_gun")
	private Set<Gun_Color> color_list;

	@ManyToOne
	@JoinColumn(name = "ammo_id")
	private Ammo ammo;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

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

	public double getWeight() {
		return weight;
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

	public Timestamp getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Timestamp added_date) {
		this.added_date = added_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}

	public Ammo getAmmo() {
		return ammo;
	}

	public void setAmmo(Ammo ammo) {
		this.ammo = ammo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@JsonIgnore
	public Set<Gun_Color> getColor_list() {
		return color_list;
	}

	public void setColor_list(Set<Gun_Color> color_list) {
		this.color_list = color_list;
	}

}
