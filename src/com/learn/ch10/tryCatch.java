package com.learn.ch10;

/**
 * <p>
 * Using try/catch to manually handle exception
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class tryCatch {
	public static void main(String[] args) {
			
		try {
			//checks a block of code
			int a = 43/ 0;// throws exception here
			System.out.println("Not printed");
		}
		catch(ArithmeticException e) { 
			//exception caught here
			System.out.println("Division by zero");
		}
		System.out.println("After catch statment.");
		}
}
