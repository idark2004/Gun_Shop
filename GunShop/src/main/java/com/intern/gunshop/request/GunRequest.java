package com.intern.gunshop.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GunRequest {	
	
	private String gun_name;
	private int capacity;
	private double weight;
	private String gun_description;
	private String gun_image;
	private int gun_price;
	private Integer ammo_id;
	private Integer category_id;
}
