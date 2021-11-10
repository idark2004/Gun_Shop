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
public class Cart_Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cde_id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "colored_id")
	private Gun_Color guns;
	
	private int cart_quantity;
	private int cart_price;
	private Timestamp created_date;
}
