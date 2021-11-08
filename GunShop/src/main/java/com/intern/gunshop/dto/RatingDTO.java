package com.intern.gunshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RatingDTO {

	private String gun_name;
	private String user_name;
	private int rate_point;
}
