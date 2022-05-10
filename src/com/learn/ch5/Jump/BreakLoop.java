package com.learn.ch5.Jump;

/***
 * <p>
 * usage and implementation of breaks
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BreakLoop {
	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			if (i == 10)
				break;
			System.out.println("i: " + i);
		}
		System.out.println("Loop Complete.");

		int i = 0;
		while (i < 100) {
			if (i == 0)
				break;
			System.out.println("i: " + i);
			i++;
		}
		System.out.println("Loop Complete.");
	}
}
