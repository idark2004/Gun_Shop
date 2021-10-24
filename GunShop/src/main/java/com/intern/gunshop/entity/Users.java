package com.intern.gunshop.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String email;
	private String pass_word;
	private LocalDate birth_date;
	private Timestamp created_date;
	private boolean user_status;	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "user")	
	private Set<Gun_Rating> gun_rating;

	public Users() {
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public boolean isUser_status() {
		return user_status;
	}

	public void setUser_status(boolean user_status) {
		this.user_status = user_status;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	@JsonIgnore
	public Set<Gun_Rating> getGun_rating() {
		return gun_rating;
	}

	public void setGun_rating(Set<Gun_Rating> gun_rating) {
		this.gun_rating = gun_rating;
	}
		

}
