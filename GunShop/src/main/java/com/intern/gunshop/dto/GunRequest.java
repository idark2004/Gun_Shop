package com.intern.gunshop.dto;

import java.sql.Timestamp;

public class GunRequest {
	
	public int capacity;
	public double weight;
	public String gun_description;
	public String gun_image;
	public boolean gun_status;
	public int gun_price;
	public Timestamp added_date;
	public Timestamp modified_date;
	public Integer ammo_id;
	public Integer category_id;
}
