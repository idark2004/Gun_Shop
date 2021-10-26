package com.intern.gunshop.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gun_Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rate_id;

	@ManyToOne
	@JoinColumn(name = "gun_id")
	private Gun gun;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	private int rated_point;
	private Timestamp rated_date;

	public Gun_Rating() {
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public Users getUser() {
		return user;
	}

	public int getRate_id() {
		return rate_id;
	}

	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getRated_point() {
		return rated_point;
	}

	public void setRated_point(int rated_point) {
		this.rated_point = rated_point;
	}

	public Timestamp getRated_date() {
		return rated_date;
	}

	public void setRated_date(Timestamp rated_date) {
		this.rated_date = rated_date;
	}

}
