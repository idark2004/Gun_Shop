package com.intern.gunshop.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private String message;
	private HttpStatus httpStatus;
	private ZonedDateTime timestamp;
	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {		
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
	
	public ApiException() {
		this.message = "";
		this.httpStatus = null;
		this.timestamp = null;		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
}
