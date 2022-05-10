package com.learn.ch5.iteration;

/**
 * <p>
 * For-each loop's disadvantages
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class NoChange {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int x : nums) {
			System.out.print(x + " ");
			x *= 10;
		}

		System.out.println();

		for (int x : nums)
			System.out.print(x + " ");
	}
}
