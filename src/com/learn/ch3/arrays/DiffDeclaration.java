package com.learn.ch3.arrays;

/**
 * <p>
 * The class specifics the different format the arrays can be declared
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class DiffDeclaration {

	public static void main(String[] args) {
		int[] arr1 = new int[2];// An array can be declared in either of these two formats
		int[][] arr = { { 1, 2 }, { 2, 4 } };// 2d array
		int arr2[] = new int[3];// Type of declaration which is dominant in c
		int[] arr3 = { 1, 2, 3, 4 };// Initializing the array with the values
		int[] arr4 = new int[] { 1, 2, 3 };// another method in which array is initialized with values
	}
}
