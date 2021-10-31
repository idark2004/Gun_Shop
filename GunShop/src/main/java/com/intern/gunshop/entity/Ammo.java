package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ammo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ammo_id;
	private String ammo_name;
	private int rounds;
	private int ammo_quantity;
	private int ammo_price;
	private double ammo_weight;
	private LocalDate added_date;
	private Timestamp modified_date;
	private boolean ammo_status;

	@OneToMany(mappedBy = "ammo",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Gun> gun_list;

}
