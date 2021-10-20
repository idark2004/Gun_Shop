package com.intern.gunshop.exception;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Customize error and message
@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e){
		ApiException api = new ApiException();
		api.setMessage("No data found in database");
		api.setHttpStatus(HttpStatus.NOT_FOUND);
		api.setTimestamp(ZonedDateTime.now());
		return new ResponseEntity<Object>(api , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException a){		
		ApiException api = new ApiException(a.getMessage(),a.getStatus(),ZonedDateTime.now());
		
		return new ResponseEntity<Object>(api,a.getStatus());
	}
}
