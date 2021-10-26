package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ammo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ammo_id;
	private int rounds;
	private int ammo_quantity;
	private int ammo_price;
	private double ammo_weight;
	private LocalDate added_date;
	private Timestamp modified_date;
	private boolean ammo_status;
	
	@OneToMany(mappedBy = "ammo")
	private Set<Gun> gun_list;
	
	public Ammo() {}

	public int getAmmo_id() {
		return ammo_id;
	}

	public void setAmmo_id(int ammo_id) {
		this.ammo_id = ammo_id;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public int getAmmo_quantity() {
		return ammo_quantity;
	}

	public void setAmmo_quantity(int ammo_quantity) {
		this.ammo_quantity = ammo_quantity;
	}

	public int getAmmo_price() {
		return ammo_price;
	}

	public void setAmmo_price(int ammo_price) {
		this.ammo_price = ammo_price;
	}

	public double getAmmo_weight() {
		return ammo_weight;
	}

	public void setAmmo_weight(double ammo_weight) {
		this.ammo_weight = ammo_weight;
	}

	public LocalDate getAdded_date() {
		return added_date;
	}

	public void setAdded_date(LocalDate added_date) {
		this.added_date = added_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isAmmo_status() {
		return ammo_status;
	}

	public void setAmmo_status(boolean ammo_status) {
		this.ammo_status = ammo_status;
	}

	@JsonIgnore
	public Set<Gun> getGun_list() {
		return gun_list;
	}

	public void setGun_list(Set<Gun> gun_list) {
		this.gun_list = gun_list;
	}
		
		
}
