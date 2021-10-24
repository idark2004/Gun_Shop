package com.intern.gunshop.entity;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Gun_Rating {
	
	@EmbeddedId
	private Gun_Rating_Id id;
	
	@ManyToOne
	@MapsId("gun_id")
	@JoinColumn(name = "gun_id")
	private Gun gun;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private Users user;
	
	private int rated_point;	
	private Timestamp rated_date;
	
	public Gun_Rating() {}

	public Gun_Rating(Gun gun, Users user, int rated_point, Timestamp rated_date) {
		this.id = new Gun_Rating_Id(gun.getGun_id(), user.getUser_id());
		this.gun = gun;
		this.user = user;
		this.rated_point = rated_point;
		this.rated_date = rated_date;
	}

	public Gun_Rating_Id getId() {
		return id;
	}

	public void setId(Gun_Rating_Id id) {
		this.id = id;
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
