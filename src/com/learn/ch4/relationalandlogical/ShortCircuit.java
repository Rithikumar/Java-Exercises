package com.learn.ch4.relationalandlogical;

/**
 * <p>
 * Working of short circuit operators
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ShortCircuit {
	public static void main(String[] args) {
		int a = 1;
		boolean a1 = true | a++ == 2;
		System.out.println(a);
		int b = 1;
		boolean a2 = true || b++ == 2;
		System.out.println(b);
		int c = 1;
		boolean a3 = false || c++ == 2;
		System.out.println(c);

		boolean a4 = false && a / 0 > 1;
		System.out.println(a4);
	}
}
