package com.intern.gunshop.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class UserRequest {
	public String user_name;
	public String email;
	public String pass_word;
	public LocalDate birth_date;
	public Timestamp created_date;
	public boolean user_status;
}
