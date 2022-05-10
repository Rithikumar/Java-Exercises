package com.learn.ch5.Iteration;

/**
 * <p>
 * A simple program to check whether the given number is present in the array or
 * not
 * </p>
 * <p>
 * Where For-each shines the most
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Search {
	public static void main(String[] args) {
		int[] nums = { 6, 8, 3, 7, 5, 6, 1, 4 };
		int val = 5;
		boolean found = false;

		for (int x : nums)
			if (x == val) {
				found = true;
				break;
			}

		if (found)
			System.out.println("Value found!");
	}
}
