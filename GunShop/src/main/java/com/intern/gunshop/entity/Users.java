package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Schema(hidden = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	private String email;	
	private String pass_word;
	private LocalDate birth_date;
	private Timestamp created_date;
	private boolean user_status;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
				joinColumns = {
						@JoinColumn(name = "user_id")
				},
				inverseJoinColumns = {
						@JoinColumn(name = "role_id")
				})	
	private Collection<Role> roles = new ArrayList<Role>();

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Gun_Rating> gun_rating;

	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	private Set<Orders> orders;

}
