package com.intern.gunshop.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GunDTO {

	private int gun_id;
	private String gun_name;
	private int capacity;
	private double weight;
	private String gun_description;
	private String gun_image;
	private boolean gun_status;
	private int gun_price;
	private Integer category_id;
	private Timestamp added_date;
	private Timestamp modified_date;
}
