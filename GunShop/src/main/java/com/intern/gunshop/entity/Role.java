package com.intern.gunshop.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int role_id;

	@Column(unique = true)
	private String role_name;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Users> users;

	public Role() {
	}

	@JsonIgnore
	public Set<Users> getUser() {
		return users;
	}

	public void setUser(Set<Users> users) {
		this.users = users;
	}

	public Role(String role_name) {
		this.role_name = role_name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
