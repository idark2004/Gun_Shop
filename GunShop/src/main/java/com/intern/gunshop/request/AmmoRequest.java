package com.intern.gunshop.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmmoRequest {
	private String ammo_name;
	private int rounds;
	private int ammo_quantity;
	private int ammo_price;
	private double ammo_weight;
}
