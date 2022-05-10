package com.learn.ch3.variables;

/**
 * <p>
 * Dynamic assigning of the values
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Dynamic {
	public static void main(String[] args) {
		double a = 3.0, b = 4.0;// here the values of a and b are initialized without any expression evaluating
								// it
		// the result of expression is stored in the variable c thus dynamically storing
		// the value of c
		double c = Math.sqrt(a * a + b * b);

		System.out.println("Hypotenuse is " + c);
	}
}
