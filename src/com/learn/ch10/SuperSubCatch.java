package com.learn.ch10;

/**
 * This program contains an error
 * 
 * A subclass must come before its superclass in a series of catch statements.if not, unreachable code will be created and a compile-time error will be the result
 * @author rithi-zstch1028
 *
 */
public class SuperSubCatch {
	
	public static void main(String[] args) {
		try {
			int a = 0;
			int b = 42/a;
		}
		catch(Exception e){
			System.out.println("Generic Exception catch.");
		}
//		catch(ArithmeticException e) {// Error - unreachable
//			System.out.println("Can't be reached");
//		}
		 
	}
}
