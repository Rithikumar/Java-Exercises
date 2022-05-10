package com.learn.ch3.variables;

/**
 * <p>
 * Test class in which the lifetime of variable are explored
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class LifeTime {
	public static void main(String[] args) {
		int x;// x is declared here

		for (x = 0; x < 3; x++) {

			int y = -1;// variable y is assigned the here
			System.out.println("y is: " + y);

			y = 100;// each time the loop runs the y is initialized again
			System.out.println("y is now: " + y);

		}
		// System.out.println(y); Throws error
		// This shows error because the lifetime of the y is within the for loop
	}
}
