package com.intern.gunshop.service;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int user_id;
	private String user_name;
	private String email;
	private String pass_word;
	private LocalDate birth_date;
	private Timestamp created_date;
	private boolean user_status;
	private String role_name;
}
