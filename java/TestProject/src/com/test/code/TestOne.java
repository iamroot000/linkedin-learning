package com.test.code;

import com.test.common.Constants;

//ExampleClass1.java
//This is an example dummy code for Class 1 that uses the Constants class and has some error handling.
public class TestOne {
	public static void main(String[] args) {
		// Sample input, change as needed
		String input = null;

		// Check for null input
		if (input == null) {
			handleError(Constants.ERROR_CODE_NULL_INPUT);
			return;
		}
	}

	public static int performOperation(String input) {
		// Dummy operation that parses the input and returns an integer
		int value = Integer.parseInt(input);
		if (value < 0) {
			throw new IllegalArgumentException("Input cannot be negative");
		}
		return value * 2;
	}

	public static void handleError(int errorCode) {
		switch (errorCode) {
		case Constants.ERROR_CODE_NULL_INPUT:
			System.err.println("Error in Class 1: Null input detected.");
			break;
		case Constants.ERROR_CODE_INVALID_VALUE:
			System.err.println("Error in Class 1: Invalid value detected.");
			break;
		default:
			System.err.println("Unknown error occurred in Class 1.");
		}
	}
}