package com.intern.gunshop.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

}
