package com.intern.gunshop.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	private LocalDate birth_date;
	private Timestamp created_date;
	private boolean user_status;
	private List<String> role_name = new ArrayList<String>();
}
