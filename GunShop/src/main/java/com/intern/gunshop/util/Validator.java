package com.intern.gunshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.intern.gunshop.exception.ApiRequestException;

public class Validator {
	
	public static void checkPasswordLength(String s) {
		if(s.length() <4 || s.length()>8)
			throw new ApiRequestException("Password need to be from 4 to 8 characters");
	}
	
	public static void checkMailFormat(String s) {
		String regex = "^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(s);
	    if(!matcher.matches())
	    	throw new ApiRequestException("Please use right email format!");
	}
	
	public static void checkName(String s) {
		String regex = ".*\\d.*";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(s);
	    if(matcher.matches() || s.length() < 2)
	    	throw new ApiRequestException("Please enter correct name with at least 2 characters!");
	}
	
}
