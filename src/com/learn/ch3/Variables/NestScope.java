package com.learn.ch3.Variables;

/**
 * <p>
 * Scopes are experimented here
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class NestScope {

	public static void main(String[] args) {

		int x;

		x = 10;
		if (x == 10) {
			int y = 20;
			System.out.println("x and y: " + x + " " + y);
			x = y * 2;
		}
		// y = 100;
		System.out.println("x is " + x);
	}

}
