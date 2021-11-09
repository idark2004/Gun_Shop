package com.intern.gunshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailDTO {

	private int detail_id;
	private String color;
	private String gun_name;
	private int quantity;
	private int total;
}
