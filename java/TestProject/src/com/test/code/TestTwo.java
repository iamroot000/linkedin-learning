package com.test.code;

import com.test.common.Constants;

//ExampleClass2.java
//This is an example dummy code for Class 2 that uses the Constants class and has some error handling.
public class TestTwo {
public static void main(String[] args) {
   // Sample input, change as needed
   int numerator = 10;
   int denominator = 0;

   // Check for division by zero
   if (denominator == 0) {
       handleError(Constants.ERROR_CODE_DIVISION_BY_ZERO);
       return;
   }

   // Perform division
   try {
       int result = numerator / denominator;
       System.out.println("Result: " + result);
   } catch (ArithmeticException e) {
       handleError(Constants.ERROR_CODE_INVALID_VALUE);
   }
}

public static void handleError(int errorCode) {
   switch (errorCode) {
       case Constants.ERROR_CODE_DIVISION_BY_ZERO:
           System.err.println("Error in Class 2: Division by zero.");
           break;
       case Constants.ERROR_CODE_INVALID_VALUE:
           System.err.println("Error in Class 2: Invalid value detected.");
           break;
       default:
           System.err.println("Unknown error occurred in Class 2.");
   }
}
}