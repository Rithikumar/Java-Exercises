package com.learn.ch5.Iteration;

/**
 * <p>
 * Usage of break in loop and its effects
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ForEach2 {
	public static void main(String[] args) {
		int sum = 0;
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int x : nums) {
			System.out.println("Value is: " + x);
			sum += x;
			if (x == 5)
				break;
		}
		System.out.println("Summation of first 5 elements: " + sum);
	}
}
