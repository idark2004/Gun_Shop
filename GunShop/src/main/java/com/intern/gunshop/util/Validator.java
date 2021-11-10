package com.intern.gunshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.intern.gunshop.exception.ApiRequestException;

public class Validator {

	public static void checkPasswordLength(String s) {
		if (s.length() < 4 || s.length() > 8)
			throw new ApiRequestException("Password need to be from 4 to 8 characters");
	}

	public static void checkMailFormat(String s) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches())
			throw new ApiRequestException("Please use right email format!");
	}

	public static void checkName(String s) {
		String regex = ".*\\d.*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (matcher.matches() || s.length() < 2)
			throw new ApiRequestException("Please enter correct name with at least 2 characters!");
	}

	public static void checkGunStringLengthUpdate(String s, int min, String input) {
		if (s != null) {
			if (s.length() < 2) {
				throw new ApiRequestException("Please enter " + input + " with atleast " + min + " character");
			}
		}
	}

	public static void checkGunStringLengthCreate(String s, int min, String input) {
		if (s == null) {
			throw new ApiRequestException("Please enter something for : " + s);
		}
		if (s.length() < 2) {
			throw new ApiRequestException("Please enter " + input + " with atleast " + min + " character");
		}
	}

	public static void checkPositiveNumber(int num) {
		if (num < 0) {
			throw new ApiRequestException("Please enter a positive number");
		}
	}

	public static void checkRatePoint(int rate) {
		checkPositiveNumber(rate);
		if(rate < 1 || rate > 5 ) {
			throw new ApiRequestException("Please rate from 1 to 5");
		}
	}

	public static void checkCartQuantity(int cart_quantity) {
		if(cart_quantity < 1) {
			throw new ApiRequestException("Please choose at least 1 item");
		}
		
	}
}
