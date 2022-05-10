package com.learn.ch5.Iteration;

/**
 * <p>
 * Usage of nested for loops and its implementation
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class MultiFor {
	public static void main(String[] args) {
		int sum = 0;
		int nums[][] = new int[3][5];

		// normal for loop
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				nums[i][j] = (i + 1) * (j + 1);
			}
		}

		// for-each

		for (int[] i : nums) {
			for (int j : i) {
				System.out.println("Value is : " + j);
				sum += j;
			}
		}

		System.out.println("Summation: " + sum);

	}
}
