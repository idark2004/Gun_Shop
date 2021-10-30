package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;

	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Users user;

	@OneToMany(mappedBy = "cart")
	@JsonIgnore
	private Set<Cart_Detail> detail;

	public int getCart_id() {
		return cart_id;
	}

	public Users getUser() {
		return user;
	}

	
	public Set<Cart_Detail> getDetail() {
		return detail;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setDetail(Set<Cart_Detail> detail) {
		this.detail = detail;
	}

}
