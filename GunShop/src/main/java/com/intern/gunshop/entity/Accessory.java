package com.intern.gunshop.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Accessory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accessory_id;
	private String accessory_name;
	private int accessory_quantity;
	private int accessory_price;
	private String accessory_description;
	private Timestamp added_date;
	private Timestamp modified_date;
	private boolean accessory_status;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Accessory() {}

	public int getAccessory_id() {
		return accessory_id;
	}

	public void setAccessory_id(int accessory_id) {
		this.accessory_id = accessory_id;
	}

	public String getAccessory_name() {
		return accessory_name;
	}

	public void setAccessory_name(String accessory_name) {
		this.accessory_name = accessory_name;
	}

	public int getAccessory_quantity() {
		return accessory_quantity;
	}

	public void setAccessory_quantity(int accessory_quantity) {
		this.accessory_quantity = accessory_quantity;
	}

	public int getAccessory_price() {
		return accessory_price;
	}

	public void setAccessory_price(int accessory_price) {
		this.accessory_price = accessory_price;
	}

	public String getAccessory_description() {
		return accessory_description;
	}

	public void setAccessory_description(String accessory_description) {
		this.accessory_description = accessory_description;
	}

	public Timestamp getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Timestamp added_date) {
		this.added_date = added_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isAccessory_status() {
		return accessory_status;
	}

	public void setAccessory_status(boolean accessory_status) {
		this.accessory_status = accessory_status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
	
}
