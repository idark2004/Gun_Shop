package com.intern.gunshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaintGunDTO {

	private String gun_name;
	private String color_name;
	private int quantity;
	private boolean is_having;
}
