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

@Entity
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

	private int quantity;

	public Gun_Color() {
	}

	public int getColored_id() {
		return colored_id;
	}

	public void setColored_id(int colored_id) {
		this.colored_id = colored_id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Gun getColored_gun() {
		return colored_gun;
	}

	public void setColored_gun(Gun colored_gun) {
		this.colored_gun = colored_gun;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Set<Cart_Detail> getCart() {
		return cart;
	}

	public void setCart(Set<Cart_Detail> cart) {
		this.cart = cart;
	}

	
}
