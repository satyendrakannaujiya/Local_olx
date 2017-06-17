package com.satyendra.validation;

public class Validator {

	public static boolean isValidNumber(final String number) {
		boolean flag = true;
		try {
			Double num = Double.parseDouble(number);
		} catch (NumberFormatException nfEx) {
			flag = false;

		}
		return flag;
	}

	public static boolean isNullOrEmpty(final String value) {
		return "".equals(trimmedString(value));
	}

	private static String trimmedString(final String value) {
		return value == null ? "":value.trim();
		
	}
}
