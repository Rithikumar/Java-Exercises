package com.learn.ch10;

/**
 * <p>
 * Catching multiple exceptions for single block of code
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class MultiCatch {
	public static void main(String[] args) {
		try {
			int a = args.length;
			System.out.println("a = " + a);
			int b = 42 / a;
			int[] c = { 1 };
			c[43] = 99;
		} catch (ArithmeticException e) {
			System.out.println("Divide by 0: " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index oob: " + e);
		}
		System.out.println("After try and catch blocks");
	}
}
