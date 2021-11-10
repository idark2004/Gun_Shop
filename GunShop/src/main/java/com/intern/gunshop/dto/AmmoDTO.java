package com.intern.gunshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmmoDTO {

	private int ammo_id;
	private String ammo_name;
	private int rounds;
	private int ammo_quantity;
	private int ammo_price;
	private double ammo_weight;
	private boolean ammo_status;
}
