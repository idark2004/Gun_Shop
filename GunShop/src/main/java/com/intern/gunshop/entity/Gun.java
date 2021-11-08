package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Schema(hidden = true)
@Data
@NoArgsConstructor
public class Gun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gun_id;
	private String gun_name;
	private int capacity;
	private double weight;
	private String gun_description;
	private String gun_image;
	private boolean gun_status;
	private int gun_price;
	private Timestamp added_date;
	private Timestamp modified_date;

	@JsonIgnore
	@OneToMany(mappedBy = "gun", cascade = CascadeType.MERGE)
	private Set<Gun_Rating> gun_rating;

	@JsonIgnore
	@OneToMany(mappedBy = "colored_gun", cascade = CascadeType.MERGE)
	private Set<Gun_Color> color_list;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ammo_id")
	private Ammo ammo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id")
	private Category category;

}
