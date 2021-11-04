package com.intern.gunshop.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class GetTime {

	public static LocalDate getDate() {
		return LocalDate.now();		
	}
	
	public static LocalDateTime getDateTime() {
		return LocalDateTime.now();
	}
	
	public static Timestamp getTimestamp() {
		return Timestamp.valueOf(getDateTime());
	}
}
