package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int color_id;
	
	private String color_name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "color")
	private Set<Gun_Color> gun_list;
		
}
