package com.intern.gunshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Gun_Rating_Id implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "gun_id")
	private Integer gun_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	
	public Gun_Rating_Id() {}

	public Gun_Rating_Id(Integer gun_id, Integer user_id) {		
		this.gun_id = gun_id;
		this.user_id = user_id;
	}	
	
}
