package com.intern.gunshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDetailDTO {

	private int cde_id;
	private int cart_quantity;
	private String gun_name;
	private String color;
	private int cart_price;
}
