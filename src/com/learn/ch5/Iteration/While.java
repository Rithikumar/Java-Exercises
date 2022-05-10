package com.learn.ch5.Iteration;

/**
 * <p>
 * The implementation of while loop
 * <p>
 * 
 * @author rithi-zstch1028
 *
 */
public class While {
	public static void main(String[] args) {
		int n = 10;
		// true condition
		while (n > 0) {
			System.out.println("tick " + n);
			n--;
		}

		int a = 10, b = 20;
		// false condition
		while (a > b)
			System.out.println("This will not be display");

		int i = 13, j = 42;
		// finding midpoint
		while (++i < --j) {
		}

		System.out.println("Midpoint is " + i);
	}
}
