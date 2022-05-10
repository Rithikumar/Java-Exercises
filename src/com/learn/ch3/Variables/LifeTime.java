package com.learn.ch3.Variables;

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
		int x;

		for (x = 0; x < 3; x++) {
			int y = -1;
			System.out.println("y is: " + y);
			y = 100;
			System.out.println("y is now: " + y);
		}
	}
}
