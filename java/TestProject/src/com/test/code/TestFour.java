package com.test.code;

import com.test.common.Constants;

//ExampleClass4.java
//This is an example dummy code for Class 4 that uses the Constants class and has some error handling.
public class TestFour {
public static void main(String[] args) {
   // Sample input, change as needed
   int number = -5;

   // Check for negative value
   if (number < 0) {
       handleError(Constants.ERROR_CODE_INVALID_VALUE);
       return;
   }

   // Perform some operation with the number
   try {
       int result = performOperation(number);
       System.out.println("Result: " + result);
   } catch (IllegalArgumentException e) {
       handleError(Constants.ERROR_CODE_INVALID_VALUE);
   }
}

public static int performOperation(int number) {
   // Dummy operation that performs some computation
   // Replace with actual code
   return number * 2;
}

public static void handleError(int errorCode) {
   switch (errorCode) {
       case Constants.ERROR_CODE_INVALID_VALUE:
           System.err.println("Error in Class 4: Invalid value detected.");
           break;
       default:
           System.err.println("Unknown error occurred in Class 4.");
   }
}
}