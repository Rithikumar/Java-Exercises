package com.learn.ch4.relationalandlogical;

/**
 * <p>
 * Implementation and usage of ternary operator
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Ternary {
	public static void main(String[] args) {
		int i, k;

		i = 10;
		k = i < 0 ? -i : i;// get abs of i
		System.out.println("Absolute value of " + i + " is " + k);

		i = -10;
		k = i < 0 ? -i : i;// get abs of i
		System.out.println("Absolute value of " + i + " is " + k);

	}
}
