package com.learn.ch7;

/**
 * <p>
 * Exploring array.length method
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ArrayLength {
	public static void main(String[] args) {
		int[] a1 = new int[10];
		int[] a2 = { 3, 5, 7, 1, 8, 99, 44, -10 };
		int[] a3 = { 4, 3, 2, 1 };

		System.out.println("a1: " + a1.length);// array.length method returns the length in which its is initialized
		System.out.println("a2: " + a2.length);// everything within the curly braces is a member of the array
		System.out.println("a3: " + a3.length);
	}

}
