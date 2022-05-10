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
			int y = 20;// y is initialized here
			System.out.println("x and y: " + x + " " + y);
			x = y * 2;// x is changed here
		}
		// y = 100; we can't access the y as it is declared within if block
		System.out.println("x is " + x);// The value of x is accessible here because it is declared in method scope too,
		// the changes that happen in the if-block is also affected here
	}

}
