package com.learn.ch7;

/**
 * <p>
 * Printing arrays
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Recursion2 {

	static void printArray(int[] i, int j) {
		if (j == 0)
			return;
		else
			printArray(i, j - 1);
		System.out.println(i[j - 1]);
	}

	public static void main(String[] args) {

		int[] i = new int[10];
		for (int j = 0; j < 10; j++)
			i[j] = j;

		printArray(i, 10);
	}
}
