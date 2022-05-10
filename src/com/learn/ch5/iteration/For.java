package com.learn.ch5.iteration;

/**
 * <p>
 * Different type of declaration of for loops
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class For {
	// types of declaration
	public static void main(String[] args) {
		for (int i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println("i is not accessible");
		int n = 10;
		for (; n > 0;) {
			System.out.print(n + " ");
			n--;
		}
		System.out.println("n is accessible " + n);

		for (int a = 1, b = 4; a < b; a++, b--) {
			System.out.println("a = " + a);
			System.out.println("b = " + b);
		}

		for (;;) {
			System.out.println("Ahh");
		}
	}

}
