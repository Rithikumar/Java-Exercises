package com.learn.ch3.arrays;

import java.util.Arrays;

/**
 * A test class which is used to check how the 2d arrays are stored internally
 * 
 * @author rithi-zstch1028
 *
 */

public class TestArray {

	public static void main(String[] args) {

		int[][] arr1 = new int[4][];
		arr1[0] = new int[1];// declaring array in array
		arr1[1] = new int[2];
		arr1[2] = new int[3];
		arr1[3] = new int[4];
		int k = 0;
		// values assigning starts
		for (int i = 0; i < 4; i++) {
			int j = 0;
			while (j < arr1[i].length) {
				arr1[i][j] = k;
				k++;
				j++;
			}
		}

		System.out.println(Arrays.deepToString(arr1));//prints using deeptoString
	}
}
