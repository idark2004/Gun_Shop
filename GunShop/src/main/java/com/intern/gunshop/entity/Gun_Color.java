package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Gun_Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colored_id;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "gun_id")
	private Gun colored_gun;

	@OneToMany(mappedBy = "guns")
	@JsonIgnore
	private Set<Cart_Detail> cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "item")
	private Set<Order_Detail> orders;

	private int quantity;
	private boolean is_having;
}
