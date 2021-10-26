package com.intern.gunshop.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String message;
	private HttpStatus status;

	public ApiRequestException(String message) {
		super();
		this.message = message;
		this.status = HttpStatus.BAD_REQUEST;
	}

	public ApiRequestException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
