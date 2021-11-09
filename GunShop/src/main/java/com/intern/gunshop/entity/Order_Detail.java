package com.intern.gunshop.entity;

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
public class Order_Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detail_id;
	
	@ManyToOne
	@JoinColumn(name = "colored_id")
	private Gun_Color item ;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	
	private int order_quantity;
	private int order_total;
}
