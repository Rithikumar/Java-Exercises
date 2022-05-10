package com.learn.ch3.arrays;

/**
 * <p>
 * The class is used to assign values to a two dimensional array and print those
 * values
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class MultiArray {

	public static void main(String[] args) {
		int[][] twoD = new int[4][5];// a 2d array is declared
		int i, j, k = 0;
		// the assigning starts from here
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 5; j++) {
				twoD[i][j] = k;
				k++;
			}
		}
		// the printing starts from here
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 5; j++) {
				System.out.print(twoD[i][j] + " ");
			}
			System.out.println();
		}
	}
}
